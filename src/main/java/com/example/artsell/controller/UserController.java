package com.example.artsell.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.example.artsell.domain.Account;
import com.example.artsell.domain.Item;
import com.example.artsell.service.ArtSellFacade;

@Controller
@SessionAttributes({"userSession","userList"})
public class UserController {
   private ArtSellFacade artSell;

   @Autowired
   public void setArtSell(ArtSellFacade artSell) {
      this.artSell = artSell;
   }

   @RequestMapping("/loginform")
   public String home(HttpServletRequest request) throws Exception {
	   return "login";
   }

   @RequestMapping("/user/login")
   public ModelAndView login(HttpServletRequest request, @RequestParam("userId") String userId,
         @RequestParam("password") String password,
         @RequestParam(value = "forwardAction", required = false) String forwardAction, Model model)
         throws Exception {
      Account account = artSell.getAccount(userId, password);
      if (account == null) {
         return new ModelAndView("Error", "message", "Invalid username or password.  Signon failed.");
      } else {
         UserSession userSession = new UserSession(account);
         model.addAttribute("userSession", userSession);
         if (forwardAction != null) {
            return new ModelAndView("redirect:" + forwardAction);
         }
         else
            // return new ModelAndView("tiles/main"); // use Tiles
            return new ModelAndView("redirect:/user/main"); //ny수정 redirect:/user/main
      }
   }

   @RequestMapping("/user/logout")
   public String logout(HttpSession session, SessionStatus sessionStatus) throws Exception { //ny수정
      session.removeAttribute("userSession");
      session.invalidate();
      sessionStatus.setComplete();
      // return "tiles/login"; // use Tiles
      return "redirect:/loginform"; //ny수정
   }

   @RequestMapping("/user/mypage")
   public String myPage(@ModelAttribute("userSession") UserSession userSession) throws Exception {
      // String userId = userSession.getAccount().getUserId();
      return "myPage";
   }

   // 2차수정
   @RequestMapping("/user/delete")
   public String deleteAccount(HttpSession session) throws Exception {
      UserSession userSession = (UserSession) session.getAttribute("userSession");
      String userId = userSession.getAccount().getUserId();
      artSell.deleteAccount(userId);

      session.removeAttribute("userSession");
      session.invalidate();
      
      System.out.println("계정이 삭제되었습니다.");
      return "main";
   }
   
   @RequestMapping("/admin/manage")
   public String getUserList(ModelMap model) {
	   PagedListHolder<Account> userList = new PagedListHolder<Account>(this.artSell.getUserList());
	   userList.setPageSize(20);
	   model.put("userList", userList);
	   return "userList";
   }
   
   @RequestMapping("/admin/page")
	public String handleRequest(
			@RequestParam("page") String page, 
			@ModelAttribute("userList") PagedListHolder<Account> userList,
			BindingResult result) throws Exception {

		if ("next".equals(page)) {
			userList.nextPage();
		} else if ("previous".equals(page)) {
			userList.previousPage();
		} 
		
		return "userList";
	}

}