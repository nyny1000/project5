package com.example.artsell.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.example.artsell.domain.Account;
import com.example.artsell.domain.Category;
import com.example.artsell.domain.Item;
import com.example.artsell.domain.ItemForm;
import com.example.artsell.domain.Order;



public interface ArtSellFacade {
	
	//--ny id로 수정.
	Account getAccount(String userId);

	Account getAccount(String userId, String password);

	void insertAccount(Account account);

	void updateAccount(Account account);
	
	void deleteAccount(String userId);

	List<String> getUsernameList();
	
	List<Account> viewAccountList();
	//--ny


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
	
	void insertItem(ItemForm item);
	
	void deleteItem(String userId, String itemId);
	
	List<Item> getMyItemList(String userId);

	boolean isItemInStock(String itemId);


	void insertOrder(Order order);

	Order getOrder(String itemId, String userId);
	
	void SaveAuctionedItem(Order order);

	List<Order> getOrdersByUsername(String username);
	
	List<Item> getItemListByCategory(String categoryId);
	
	List<String> getArtistList();
	
	List<Item> getInterestingItemList(String userId);
	
	void insertInterestingItem(String userId, String itemId);
	
	void deleteInterestingItem(String userId, String itemId);
	
	int containsInterestingItem(String userId, String itemId);
	
	int isAuctioning(String itemId);

	Map<String, Integer> getBuyersByItemId(String itemId);
	
	int getItemPrice(String itemId);
	
	void updateReload(String itemId, int minPrice, Date deadline, String userId);
	
	

	void updatePrice(String userId, String itemId, int price);

	void updateItemBestPrice(String itemId, int price);
	
	int isNewUserPrice(String userId, String itemId);
	
	void auctionScheduler(Date closingTime);
	
	void addPrice(String userId, String itemId, int price);
	
	int calcBestPrice(String itemId);

}
