package com.example.artsell.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.artsell.domain.AuctionItem;
import com.example.artsell.service.ArtSellFacade;

@Controller
@SessionAttributes("userSession")
public class JoinAuctionController {
   @Autowired
   private ArtSellFacade artSell;
   
   //입찰, 재입찰
   @RequestMapping("/auction/bid")
   public void addAuctionItem(@ModelAttribute("userSession") UserSession userSession, 
         @RequestParam("itemId") String itemId, 
         @RequestParam("price") int price) throws Exception {
	  AuctionItem auctionItem;
	  String userId = userSession.getAccount().getUserId();
      if (auctionItem.isNewUserPrice(userId, itemId)) { //헌값 수정!
            artSell.updatePrice(userId, itemId, price);
      }
      else {   //새로운 값
         artSell.addPrice(userId, itemId, price);
      }
      
      if (artSell.getBestPrice() < price) { //최고값이면
         artSell.updateItemBestPrice(price);
      }
      else {
         throw new Exception("error");
      }

   }
   
   //낙찰포기 //if 후순위자있을경우->후순위자상태바꿈   else 
   public String giveup(@ModelAttribute("userSession") UserSession userSession, 
            @RequestParam("itemId") String itemId, ModelMap model) {

      String userId = userSession.getAccount().getUserId();
   
      //auctionitem table에서 해당 아이디 / 아이템아이디의 행 삭제
      artSell.deleteAuctionItem(userId, itemId);
   
   
      //AuctionedItem auctionedItem = artSell.getOrder(itemid); //해당 아이템가져와
   
      List<AuctionItem> auctionBuyerList = artSell.getBuyersByItemId(itemid);
   
   
      if (artSell.countAuctionJoinList != 0) // 후순위자가 있다면
      {//후순위자에게 낙찰
         AuctionItem secondAuctionitem = auctionBuyerList.get(0);
         String secondUser = secondAuctionitem.getUserId();
         String secondPrice = secondAuctionitem.getMyPrice();
         
         //해당 아이템 최고가 변경.
         artSell.updateItem(secondUser, secondPrice);
         
         changeState(secondUser, itemId);
         
         return "/auction/list";
   
      }
      else{
    	  //사는 사람은 포기하고 경매목록 리다이렉트
         return "redirect:/auction/list";
      }
   }
   
   //해당 아이템을 낙찰상태로 바꿔주기
   public static void changeState(String userId, String itemId) {
	   artSell.changeState(userId, itemId, 1);
   }
      

   // 아이템아이디에 해당하는 경매참여자들
   @RequestMapping("/auction/info")
   public String viewAutionJoinerList(@RequestParam("itemId") String itemId, ModelMap model) {   
      Map<String, Integer> buyers = this.artSell.getBuyersByItemId(itemId);
      model.put("buyers", buyers);
      return "auction/auction_buyer";
   }

   

   
   //유찰 //기간은 현재 날짜에서 7일후
   @RequestMapping("/auction/fail")
    public ModelAndView miscarry(@ModelAttribute("userSession") UserSession userSession, 
   @RequestParam("itemId") String itemId) {
      String userId = userSession.getAccount().getUserId();
      int minPrice= artSell.getItemPrice(itemId);
      minPrice = (int) (minPrice * 0.7);

      Calendar cal = Calendar.getInstance();
      cal.setTime(new Date());
      DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

      cal.add(Calendar.DATE, 7);
      Date deadline = null;
      try {
    	  deadline = df.parse(df.format(cal.getTime()));
      } catch (ParseException e) {
          e.printStackTrace();
      }
      
      ModelAndView model = new ModelAndView("myPainting_bidding");
      model.addObject("minPrice", minPrice);
      model.addObject("deadline", deadline);
      return model;

   }
   
   @RequestMapping("/auction/fail/ok")
    public String Reupload(@ModelAttribute("userSession") UserSession userSession, @RequestParam("itemId") String itemId, 
          @RequestParam("minPrice") int minPrice, @RequestParam("deadline") Date deadline, RedirectAttributes redirectAttributes) {
	   String userId = userSession.getAccount().getUserId();
      artSell.updateReload(itemId, minPrice, deadline, userId);
      
      redirectAttributes.addAttribute("itemId", itemId);
      
      return "redirect:/shop/viewItem";
}

   //유찰 안하겠다고 했을때
   @RequestMapping("/auction/fail/no")
    public String Reupload(@ModelAttribute("userSession") UserSession userSession, @RequestParam("itemId") String itemId) {
	   String userId = userSession.getAccount().getUserId(); 
      artSell.deleteItem(userId, itemId);
      return "redirect:/home";
   }

}