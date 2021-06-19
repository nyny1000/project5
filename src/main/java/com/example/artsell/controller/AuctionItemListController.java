package com.example.artsell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.artsell.domain.AuctionItem;
import com.example.artsell.domain.AuctionedItem;
import com.example.artsell.domain.Item;
import com.example.artsell.service.ArtSellFacade;

@Controller
@SessionAttributes("userSession")
public class AuctionItemListController {
	@Autowired
	private ArtSellFacade artSell;
	
	@RequestMapping("/auction/list")
	public String viewAuctionItemList(@ModelAttribute("userSession") UserSession userSession, ModelMap model) {
		PagedListHolder<AuctionItem> itemList1 = new PagedListHolder<AuctionItem>(
				this.artSell.getItemListByAuctionItem(userSession.getAccount().getUserId()));
		itemList1.setPageSize(4);
		model.put("itemList1", itemList1);
		
		//낙찰된(결제까지 다 한) 목록
		PagedListHolder<AuctionedItem> itemList2 = new PagedListHolder<AuctionedItem>(
				this.artSell.getItemListByAuctionedItem(userSession.getAccount().getUserId()));
		itemList2.setPageSize(4);
		model.put("itemList2", itemList2);

		return "myAuctionList";
	
	}
	
	@RequestMapping("/auction/list/auction")
	public String viewAuctionItemList2(
			@RequestParam("page") String page, 
			@ModelAttribute("auctionList") PagedListHolder<Item> itemList,
			BindingResult result) throws Exception {

		if ("next".equals(page)) {
			itemList.nextPage();
		} else if ("previous".equals(page)) {
			itemList.previousPage();
		} 
		
		return "myAuctionList";
	} 
	
	@RequestMapping("/auction/list/auctioned")
	public String viewAuctionItemList3(
			@RequestParam("page") String page, 
			@ModelAttribute("auctionedList") PagedListHolder<Item> itemList,
			BindingResult result) throws Exception {

		if ("next".equals(page)) {
			itemList.nextPage();
		} else if ("previous".equals(page)) {
			itemList.previousPage();
		} 
		
		return "myAuctionList";
	}

}
