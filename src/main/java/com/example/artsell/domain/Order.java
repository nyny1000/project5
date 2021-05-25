package com.example.artsell.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.example.artsell.domain.Account;
import com.example.artsell.domain.Item;
import com.example.jpetstore.domain.Cart;
import com.example.jpetstore.domain.CartItem;
import com.example.jpetstore.domain.LineItem;

@SuppressWarnings("serial")
public class Order implements Serializable {

	private String userId;
	private String userName;
	private String itemName;
	private String itemId;
	private String phone;
	private String destination;
	private int auctionedPrice;
	private String credit;
	private Date orderDate;
	//private List<LineItem> lineItems = new ArrayList<LineItem>();
	private AuctionItem auctionItem;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getAuctionedPrice() {
		return auctionedPrice;
	}
	public void setAuctionedPrice(int auctionedPrice) {
		this.auctionedPrice = auctionedPrice;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public AuctionItem getAuctionItem() {
		return auctionItem;
	}
	public void setAuctionItem(AuctionItem auctionItem) {
		this.auctionItem = auctionItem;
	}
	
	  /* Public Methods */

	public void initOrder(Account account, Item item) {
		userId = account.getUserId();
		//userName = account.getUserName();
		orderDate = new Date();
		phone = account.getPhone();
		destination = account.getAddress();
		credit = account.getCredit();
		itemName = item.getItemName();
		auctionedPrice = item.getBestPrice();
	}
}
