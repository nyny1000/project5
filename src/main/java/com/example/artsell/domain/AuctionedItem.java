package com.example.artsell.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class AuctionedItem implements Serializable {
	private String userId;
	private String itemName;
	private String itemId;
	private int auctionedPrice;
	private String desination;
	private Date deadline;
	private String picture;
	private Date sellDate;
	
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
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Date getSellDate() {
		return sellDate;
	}
	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}
	
	
	
}
