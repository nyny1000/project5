package com.example.artsell.service;

import java.util.List;

import com.example.artsell.domain.Account;
import com.example.artsell.domain.Category;
import com.example.artsell.domain.Item;
import com.example.jpetstore.domain.Order;


public interface ArtSellFacade {
	Account getAccount(String username);

	Account getAccount(String username, String password);

	void insertAccount(Account account);

	void updateAccount(Account account);

	List<String> getUsernameList();


	List<Category> getCategoryList();

	Category getCategory(String categoryId);

	/*
	 * List<Item> searchItemList(String keywords, String categoryId);
	 * 
	 * List<Item> searchItemListByArtist(String keywords, String artist, String
	 * categoryId);
	 */

	List<Item> searchItemList(String keywords, String artist, String categoryId);
	
	List<Item> getItemListByProduct(String productId);

	Item getItem(String itemId);

	boolean isItemInStock(String itemId);


	void insertOrder(Order order);

	Order getOrder(int orderId);

	List<Order> getOrdersByUsername(String username);
	
	List<Item> getItemListByCategory(String categoryId);
	
	List<String> getArtistList();
}
