package com.example.artsell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.jpetstore.service.ArtSellFacade;

public class AuctionItemListController {
	@Autowired
	private ArtSellFacade artSell;
	public String viewAuctionItemList(@ModelAttribute("userSession") UserSession userSession, ModelMap model) {
		PagedListHolder<Item> itemList = new PagedListHolder<Item>(this.artSell.getItemListByAuctionItem(userSession.getAccount().getUserId());
		//ItemList.setPageSize(8);
		model.put("itemList", itemList);
		return "myAuctionList";
	}

}
