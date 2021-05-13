package com.example.jpetstore.domain;

import java.util.Date;

public class InterestingItem {
	private String itemId;
	private Date deadLine;
	private String bestPrice;
	
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public Date getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	public String getBestPrice() {
		return bestPrice;
	}
	public void setBestPrice(String bestPrice) {
		this.bestPrice = bestPrice;
	}
	
	
}
