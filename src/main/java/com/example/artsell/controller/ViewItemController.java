package com.example.artsell.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.artsell.domain.Item;
import com.example.artsell.service.ArtSellFacade;

@Controller
@SessionAttributes("UserSession")
public class ViewItemController { 

	private ArtSellFacade artSell;

	@Autowired
	public void setartSell(ArtSellFacade artSell) {
		this.artSell = artSell;
	}

	@RequestMapping("/shop/viewItem")
	public String handleRequest(@RequestParam("itemId") String itemId, ModelMap model, HttpSession session) throws Exception {
		Item item = this.artSell.getItem(itemId);
		model.put("item", item);
		
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		String userId = userSession.getAccount().getUserId();
		
		Boolean isInterested = false;
		if (artSell.containsInterestingItem(userId, itemId) == 1) {
			isInterested = true;
		}
		
		model.put("isInterested", isInterested);
		return "paintingDetail";
	}
}
