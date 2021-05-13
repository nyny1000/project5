package com.example.artsell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.jpetstore.service.ArtSellFacade;

public class AuctionItemListController {
	@Autowired
	private ArtSellFacade artSell;
	public String viewAuctionItemList(@ModelAttribute("userSession") UserSession userSession, ModelMap model) {
		PagedListHolder<Item> itemList1 = new PagedListHolder<Item>(this.artSell.getItemListByAuctionItem(userSession.getAccount().getUserId());
		//ItemList.setPageSize(8);
		model.put("itemList1", itemList2);
		
		//낙찰된(결제까지 다 한) 목록
		PagedListHolder<Item> itemList2 = new PagedListHolder<Item>(this.artSell.getItemListByAuctionedItem(userSession.getAccount().getUserId());
		//ItemList.setPageSize(8);
		model.put("itemList2", itemList2);

		return "myAuctionList";
	}

}
