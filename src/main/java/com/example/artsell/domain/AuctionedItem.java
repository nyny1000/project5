package com.example.artsell.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class AuctionedItem implements Serializable {
	private String userId;
	private String itemId;
	private int auctionedPrice;
	private String desination;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public int getAuctionedPrice() {
		return auctionedPrice;
	}
	public void setAuctionedPrice(int auctionedPrice) {
		this.auctionedPrice = auctionedPrice;
	}
	public String getDesination() {
		return desination;
	}
	public void setDesination(String desination) {
		this.desination = desination;
	}
	
}
