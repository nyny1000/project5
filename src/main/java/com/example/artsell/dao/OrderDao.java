package com.example.artsell.dao;

import org.springframework.dao.DataAccessException;

import com.example.artsell.domain.AuctionItem;
import com.example.artsell.domain.Order;

public interface OrderDao {
	Order getOrder (String itemId, String userId) throws DataAccessException;
	//AuctionItem getAuctionItem(String itemId, String userId) throws DataAccessException;
	void editDestination(Order order, String des) throws DataAccessException;
	void SaveAuctionedItem (Order order) throws DataAccessException;
}
