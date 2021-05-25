package com.example.artsell.dao;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.example.artsell.domain.AuctionItem;

public interface AuctionItemDao {
	AuctionItem getAuctionItemByItemIdAndUserId(String itemId, String userId) throws DataAccessException;

	Map<String, Integer> getBuyersByItemId(String itemId) throws DataAccessException;

	List<AuctionItem> getAllAuctionItemByUserId(String userId) throws DataAccessException;

	List<AuctionItem> getAuctionItem(String userId) throws DataAccessException;

	int calcBestPrice(String itemId) throws DataAccessException;

	void insertAuctionItem(AuctionItem auctionItem) throws DataAccessException;

	void updatePrice(String userId, String itemId, int price) throws DataAccessException;
	
	void addPrice(String userId, String itemId, int price) throws DataAccessException;
	
	void updateItemBestPrice(String itemId, int price) throws DataAccessException;

	void deleteAuctionItem(String itemId) throws DataAccessException;

	List<AuctionItem> getAuctionedItem(String userId) throws DataAccessException;

	List<AuctionItem> getOrderedItem(String userId) throws DataAccessException;

	int countAuctionJoinList(String userId) throws DataAccessException;

	void changeState(String userId, String itemId, int state) throws DataAccessException;

	int isNewUserPrice(String userId, String itemId) throws DataAccessException;

}
