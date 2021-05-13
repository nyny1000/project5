package com.example.artsell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jpetstore.service.ArtSellFacade;

public class JoinAuctionController {
	@Autowired
	private ArtSellFacade artSell;
	//입찰, 재입찰
	private void addAuctionItem(@ModelAttribute("userSession") UserSession userSession, 
			@RequestParam("ItemId") String workingItemId, 
			@RequestParam("price") int price) throws Exception {
		if (auctionItem.isNewUserPrice(userSession.getAccount().getUserId(), ItemId)) { //헌값 수정!
				artSell.updatePrice(userId, itemId, price);
		}
		else {	//새로운 값
			artSell.addPrice(userId, itemId, price);
		}
		
		if (artSell.getBestPrice() < price) { //최고값이면
			artSell.updateItemBestPrice(price);
		}
		else {
			throw new Exception("error");
		}

	}
}
