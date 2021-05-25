package com.example.artsell.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.example.artsell.domain.Account;
import com.example.artsell.domain.Item;
import com.example.artsell.service.ArtSellFacade;
//123
@Controller
@SessionAttributes({"sessionCart", "orderForm"})
public class OrderController {
	@Autowired
	private ArtSellFacade artsell;
	
	@ModelAttribute("orderForm")
	public OrderForm createOrderForm() {
		return new OrderForm();
	}

	
	@RequestMapping("/auction/auctioned_buyer")
	public String viewShippingForm(HttpServletRequest request,
			@RequestParam("itemId") String itemId,
			@ModelAttribute("orderForm") OrderForm orderForm
			) throws ModelAndViewDefiningException {
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		if (itemId != null) {
			// Re-read account from DB at team's request.
			Account account = artsell.getAccount(userSession.getAccount().getUserId());
			Item item = artsell.getItem(itemId);
			//orderForm.getOrder().initOrder(account, cart);
			//artsell.getOrder(itemId,account.getUserId());
			orderForm.getOrder().initOrder(account, item);
			return "NewOrderForm";	
		}
		else {
			ModelAndView modelAndView = new ModelAndView("Error");
			modelAndView.addObject("message", "An order could not be created because a cart could not be found.");
			throw new ModelAndViewDefiningException(modelAndView);
		}
	}
	
	//auctioned_buyer.jsp
	@RequestMapping("/auction/auctioned_destination")
	public String viewConfirmOrder(HttpServletRequest request,
			@ModelAttribute("orderForm") OrderForm orderForm, 
			BindingResult result) {	
		artsell.SaveAuctionedItem(orderForm.getOrder());
		if (result.hasErrors()) {
			return "NewOrderForm";
		}
		else {			
			return "ConfirmOrder";
		}
	}
	//auctioned_destination.jsp
	@RequestMapping("/auction/auctioned_receipt")
	public ModelAndView viewOrder(
			@ModelAttribute("orderForm") OrderForm orderForm, 
			SessionStatus status) {
		//artsell.insertOrder(orderForm.getOrder());
		ModelAndView mav = new ModelAndView("ViewOrder");
		mav.addObject("order", orderForm.getOrder());
		mav.addObject("message", "Thank you, your order has been submitted.");
		status.setComplete();  // remove sessionCart and orderForm from session
		return mav;
	}
	
}
