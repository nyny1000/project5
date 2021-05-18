package com.example.artsell.dao;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.artsell.domain.Item;

public interface ItemDao {
//	Item getItem(String itemId) throws DataAccessException;
//	
//	List<Item> searchItemListByKeyword(String keywords) throws DataAccessException;
//	
//	List<Item> searchItemListByKeyword(String keywords, String categoryId) throws DataAccessException;
//	
//	List<Item> searchItemListByArtist(String artist) throws DataAccessException;
//	
//	List<Item> searchItemListByArtist(String artist, String categoryId) throws DataAccessException;
//	
//	List<Item> searchItemList(String keywords, String artist) throws DataAccessException;
	
	List<Item> searchItemList(String keywords, String artist, String categoryId) throws DataAccessException;
	
	List<Item> getItemListByCategory(String categoryId) throws DataAccessException;
	//List<Item> getItemListByCategory(String categoryName) throws DataAccessException;
	
	List<Item> getItemListByUserId(String userId) throws DataAccessException;
	//위아래 두개 무슨 차이인지 모르겠음
	List<Item> getMyItemList(String userId) throws DataAccessException;
	
	void deleteItem(String userId, String itemId) throws DataAccessException;
	
	void insertItem(Item item) throws DataAccessException;
	
	void updateItem(String itemId, String price) throws DataAccessException;
	
	void updateReload(String itemId, int minPrice, Date deadline) throws DataAccessException;
}
