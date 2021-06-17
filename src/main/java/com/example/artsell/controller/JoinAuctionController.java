package com.example.artsell.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.example.artsell.domain.Item;
import com.example.artsell.service.ArtSellFacade;

@Controller
@SessionAttributes("userSession")
public class JoinAuctionController {
	@Autowired
	private ArtSellFacade artSell;

	// 입찰, 재입찰
	@RequestMapping("/auction/bid")
	public void addAuctionItem(@ModelAttribute("userSession") UserSession userSession,
			@RequestParam("itemId") String itemId, @RequestParam("price") int price) throws Exception {
		String userId = userSession.getAccount().getUserId();
		Item auctionItem = artSell.getItem(itemId);
		
		//첫 입찰자
		if (artSell.getBuyersByItemId(itemId).size() == 1) {
			//minPrice보다 커야 함.
			if (price >auctionItem.getMinPrice()) {
				artSell.addPrice(userId, itemId, price);
				artSell.updateItemBestPrice(itemId, price);
			}
		}
		else { //그 다음 입찰자는 maxPrice보다 크게 입찰해야 함.
			if (price > auctionItem.getBestPrice()) {
				//새로운 입찰자인지 체크
				if (artSell.isNewUserPrice(userId, itemId) > 0) { // 헌값 수정!
					artSell.updatePrice(userId, itemId, price);
				} else { // 새로운 값
					artSell.addPrice(userId, itemId, price);
				}
			}
		}
		
		//price가 최고값인 경우 아이템의 최고가 변경.
		if (artSell.calcBestPrice(itemId) < price) { // 최고값이면
			artSell.updateItemBestPrice(itemId, price);
		} else {
			throw new Exception("error");
		}

	}

	// 낙찰포기 //if 후순위자있을경우->후순위자상태바꿈 else
	public String giveup(@ModelAttribute("userSession") UserSession userSession, @RequestParam("itemId") String itemId,
			ModelMap model) {

		String userId = userSession.getAccount().getUserId();

		// auctionitem table에서 해당 아이디 / 아이템아이디의 행 삭제
		artSell.deleteAuctionItem(userId, itemId);

		List<AuctionItem> auctionBuyerList = artSell.getBuyersByItemId(itemId);

		if (auctionBuyerList != null) // 후순위자가 있다면
		{// 후순위자에게 낙찰
			AuctionItem secondAuctionitem = auctionBuyerList.get(0); // 후순위자
			String secondUser = secondAuctionitem.getUserId();
			int secondPrice = secondAuctionitem.getMyPrice();

			// 해당 아이템 최고가 변경.
			artSell.updateItemBestPrice(secondUser, secondPrice);

			changeState(secondUser, itemId, 1);

			return "redirect:/auction/list";

		} else {
			// 사는 사람은 포기하고 경매목록 리다이렉트
			//판매자아이디 5로 바꿔주기
			String sellerId = artSell.getItem(itemId).getUserId();
			changeState(sellerId, itemId, 5);
			
			return "redirect:/auction/list";
		}
	}

	// 해당 아이템의 state 바꿔주기
	public void changeState(String userId, String itemId, int state) {
		artSell.changeState(userId, itemId, state);
	}
	
	// 아이템아이디에 해당하는 경매참여자들
	public List<AuctionItem> AuctionJoinerList(String itemId) {
		return this.artSell.getBuyersByItemId(itemId);
	}

	// 아이템아이디에 해당하는 경매참여자들 buyer
	@RequestMapping("/auction/info")
	public String viewAutionJoinerList(@RequestParam("itemId") String itemId, ModelMap model) {
		System.out.print("넘어오긴 하냐");
		List<AuctionItem> buyers = AuctionJoinerList(itemId);
		model.put("buyers", buyers);
		return "auction_buyer";
	}
	
	// 아이템아이디에 해당하는 경매참여자들 seller
	@RequestMapping("/auction/joniner")
	public String AutionJoinerList(@RequestParam("itemId") String itemId, ModelMap model) {
		List<AuctionItem> buyers = AuctionJoinerList(itemId);
		model.put("buyers", buyers);
		return "auction_seller";
	}

	// 유찰 //기간은 현재 날짜에서 7일후
	@RequestMapping("/auction/fail")
	public ModelAndView miscarry(@ModelAttribute("userSession") UserSession userSession,
			@RequestParam("itemId") String itemId) {
		String userId = userSession.getAccount().getUserId();
		int minPrice = artSell.getItemPrice(itemId);
		int newPrice = (int) (minPrice * 0.7);
		newPrice = (int) (minPrice * 0.7);

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
		model.addObject("newPrice", newPrice);
		model.addObject("deadline", deadline);
		return model;

	}

	@RequestMapping("/auction/fail/ok")
	public String Reupload(@ModelAttribute("userSession") UserSession userSession,
			@RequestParam("itemId") String itemId, @RequestParam("minPrice") int minPrice,
			@RequestParam("deadline") Date deadline, RedirectAttributes redirectAttributes) {
		String userId = userSession.getAccount().getUserId();

		artSell.auctionScheduler(deadline, itemId);

		artSell.updateReload(itemId, minPrice, deadline, userId);

		redirectAttributes.addAttribute("itemId", itemId);

		return "redirect:/shop/viewItem";
	}

	// 유찰 안하겠다고 했을때
	@RequestMapping("/auction/fail/no")
	public String Reupload(@ModelAttribute("userSession") UserSession userSession,
			@RequestParam("itemId") String itemId) {
		String userId = userSession.getAccount().getUserId();
		artSell.deleteItem(userId, itemId);
		return "redirect:/home";
	}

	@RequestMapping("/auction/scheduler")
	public String handleRequest(@RequestParam("itemId") String itemId,
			@ModelAttribute("userSession") UserSession userSession) {
		System.out.println(itemId);
		Item item = this.artSell.getItem(itemId);
		Date deadline = item.getDeadline();

		// 테스트
		/*SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String date = "2021-05-28 01:06";
		Date deadline = null;
		try {
			deadline = d.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println(deadline);

		AuctionItem auctionItem = new AuctionItem();
		auctionItem.setItemId(itemId);
		auctionItem.setState(4);
		auctionItem.setUserId(userSession.getAccount().getUserId());
		artSell.insertAuctionItem(auctionItem);

		artSell.auctionScheduler(deadline, item.getItemId());
		System.out.println("부르기전");
		return "redirect:/myitem/list";
		// return "main";
	}
	
	@RequestMapping("/auction/success")
	public String success(@RequestParam("itemId") String itemId, @ModelAttribute("userSession") UserSession userSession) {
		Date now = new Date(System.currentTimeMillis());
		
		artSell.changeDeadline(now, itemId);
		artSell.bidSuccess(itemId);
		
		return "redirect:/myitem/list";  
	}
	
}