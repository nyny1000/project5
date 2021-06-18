package com.example.artsell.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
import com.example.artsell.domain.Order;
import com.example.artsell.service.ArtSellFacade;
//123
import com.example.artsell.service.OrderValidator;
@Controller
@SessionAttributes({"sessionCart", "orderForm", "order"})
public class OrderController {
	@Autowired
	private ArtSellFacade artsell;
	@Autowired
	private OrderValidator validator;
	
	public void setValidator(OrderValidator validator) {
		this.validator = validator;
	}
	
//	@ModelAttribute("orderForm")
//	public OrderForm createOrderForm() {
//		return new OrderForm();
//	}

	@RequestMapping("/auction/auctioned_buyer_addressCheck")
	public String addressCheckbox(HttpServletRequest request,
			@ModelAttribute("Order") Order order, ModelMap model) {
		order = (Order) request.getSession().getAttribute("order");
		order = artsell.getOrder(order.getItemId(), order.getUserId());
		
		model.put("order", order);
		request.getSession().setAttribute("order", order);
		
		return "auctioned_buyer";
	}
	
	
	@RequestMapping("/auction/auctioned_buyer")
	public String viewShippingForm(HttpServletRequest request,
			@RequestParam("itemId") String itemId,
			@ModelAttribute("orderForm") OrderForm orderForm, ModelMap model,
			BindingResult result) throws ModelAndViewDefiningException {
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		if (itemId != null) {
			// Re-read account from DB at team's request.
			System.out.println("123123");
			Order order = artsell.getOrder(itemId, userSession.getAccount().getUserId());
			
			order.setAddress(null);
			model.put("order", order);
			request.getSession().setAttribute("order", order);
			//Account account = artsell.getAccount(userSession.getAccount().getUserId());
			//Item item = artsell.getItem(itemId);
			//System.out.println(item.getItemName());
			//orderForm.getOrder().initOrder(account, cart);
			//artsell.getOrder(itemId,account.getUserId());
			
			return "auctioned_buyer";
		}
		else {
			ModelAndView modelAndView = new ModelAndView("Error");
			modelAndView.addObject("message", "An order could not be created because a cart could not be found.");
			throw new ModelAndViewDefiningException(modelAndView);
		}
	}
	
	@ModelAttribute("order")
	public Order aa() {
		return new Order();
	}
	
	@RequestMapping("/auction/destination")
	public String viewConfirmOrder(HttpServletRequest request,
			@Valid @ModelAttribute("Order") Order order, 
			BindingResult result, ModelMap model) {	
		//artsell.SaveAuctionedItem(order);
		if (result.hasErrors())
			return "auctioned_buyer";
		
		order = (Order) request.getSession().getAttribute("order");
//		validator.validate(order, result);
		
		model.put("order", order);
		System.out.println(order.getItemId());	
		return "auctioned_destination";
	}
	
	@RequestMapping("/auction/receipt")
	public String viewOrder(HttpServletRequest request,
			@ModelAttribute("orderForm") OrderForm orderForm, 
			SessionStatus status) {
		//artsell.insertOrder(orderForm.getOrder());
		Order order = (Order) request.getSession().getAttribute("order");
		
		System.out.println(order.getMyPrice());
		artsell.SaveAuctionedItem(order.getItemId(), order.getMyPrice(), order.getUserId(), order.getAddress());//db에 저장
		System.out.println("1");
		artsell.updateAuctionedState(order.getItemId(), order.getUserId());
		System.out.println("2");
		
		ModelAndView mav = new ModelAndView("ViewOrder");
		mav.addObject("order", order);
		mav.addObject("message", "Thank you, your order has been submitted.");
		status.setComplete();  // remove sessionCart and orderForm from session
		return "auctioned_receipt";
	}
	
}
