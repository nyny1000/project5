package com.example.artsell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jpetstore.domain.Item;
import com.example.jpetstore.service.ArtSellFacade;

@Controller
public class ViewItemController { 

	private ArtSellFacade artSell;

	@Autowired
	public void setartSell(ArtSellFacade artSell) {
		this.artSell = artSell;
	}

	@RequestMapping("/shop.viewItem")
	public String handleRequest(@RequestParam("itemId") String itemId, ModelMap model) throws Exception {
		Item item = this.artSell.getItem(itemId);
		model.put("item", item);
		return "paintingDetail";
	}
}
