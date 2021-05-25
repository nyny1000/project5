package com.example.artsell.dao;

import java.util.Date;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface AuctionItemDao {
	Map<String, Integer> getBuyersByItemId(String itemId) throws DataAccessException;
	
	void updateReload(String itemId, int minPrice, Date deadline) throws DataAccessException;
}
