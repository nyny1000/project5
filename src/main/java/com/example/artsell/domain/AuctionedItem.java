package com.example.artsell.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AuctionedItem implements Serializable {
	private String userId;
	private String itemId;
	private int auctionedPrice;
	private int destination;
	
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
	public int getDestination() {
		return destination;
	}
	public void setDestination(int destination) {
		this.destination = destination;
	}
}
