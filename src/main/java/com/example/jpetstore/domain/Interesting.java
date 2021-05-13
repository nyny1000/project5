package com.example.jpetstore.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.support.PagedListHolder;

@SuppressWarnings("serial")
public class Interesting implements Serializable {
	private final Map<String, InterestingItem> itemMap = Collections
			.synchronizedMap(new HashMap<String, InterestingItem>());

	private final PagedListHolder<InterestingItem> itemList = new PagedListHolder<InterestingItem>();

	/* JavaBeans Properties */

	public Interesting() {
		this.itemList.setPageSize(5);
	}

	public Iterator<InterestingItem> getAllInterestingItems() {
		return itemList.getSource().iterator();
	}

	public PagedListHolder<InterestingItem> getInterestingItemList() {
		return itemList;
	}

	public int getNumberOfItems() {
		return itemList.getSource().size();
	}

	/* Public Methods */

	public boolean containsItemId(String itemId) {
		return itemMap.containsKey(itemId);
	}

	public void addItem(Item item, boolean isInStock) {
		InterestingItem interestingItem = itemMap.get(item.getItemId());
		if (interestingItem == null) {
			interestingItem = new InterestingItem();
			interestingItem.setItem(item);
			interestingItem.setQuantity(0);
			interestingItem.setInStock(isInStock);
			itemMap.put(item.getItemId(), interestingItem);
			itemList.getSource().add(interestingItem);
		}
		interestingItem.incrementQuantity();
	}

	public Item removeItemById(String itemId) {
		CartItem cartItem = itemMap.remove(itemId);
		if (cartItem == null) {
			return null;
		} else {
			itemList.getSource().remove(cartItem);
			return cartItem.getItem();
		}
	}
}
