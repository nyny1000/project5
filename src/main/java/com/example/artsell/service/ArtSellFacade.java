package com.example.artsell.service;

import java.util.List;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Category;
import com.example.artsell.domain.Item;
import com.example.jpetstore.domain.Order;
import com.example.jpetstore.domain.Product;

public interface ArtSellFacade {
	Account getAccount(String username);

	Account getAccount(String username, String password);

	void insertAccount(Account account);

	void updateAccount(Account account);

	List<String> getUsernameList();


	List<Category> getCategoryList();

	Category getCategory(String categoryId);
	

	List<Product> getProductListByCategory(String categoryId);

	List<Item> searchItemList(String keywords, String categoryId);
	
	List<Item> searchItemListByArtist(String keywords, String artist, String categoryId);

	Product getProduct(String productId);


	List<Item> getItemListByProduct(String productId);

	Item getItem(String itemId);

	boolean isItemInStock(String itemId);


	void insertOrder(Order order);

	Order getOrder(int orderId);

	List<Order> getOrdersByUsername(String username);
	
	List<Item> getItemListByCategory(String categoryId);
	
	List<Item> getInterestingItemList(String userId);
	
	void insertInterestingItem(String userId, String itemId);
	
	void deleteInterestingItem(String userId, String itemId);
	
	int containsInterestingItem(String userId, String itemId);
	
	
}
