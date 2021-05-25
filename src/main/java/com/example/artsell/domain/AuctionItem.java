package com.example.artsell.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AuctionItem implements Serializable {
	private String userId;
	private String itemId;
	private int myPrice;
	private int state;
	
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
	public int getMyPrice() {
		return myPrice;
	}
	public void setMyPrice(int myPrice) {
		this.myPrice = myPrice;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	public boolean isNewUserPrice(String userId, String itemId) {
		if (this.itemId == itemId && this.userId == itemId) {
			return true;
		}
		else
			return false;
	}
}
