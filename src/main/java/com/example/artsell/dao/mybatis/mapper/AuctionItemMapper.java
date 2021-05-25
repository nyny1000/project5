package com.example.artsell.dao.mybatis.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import com.example.artsell.domain.AuctionItem;

@Mapper
public interface AuctionItemMapper {
	AuctionItem getAuctionItemByItemIdAndUserId(String itemId, String userId) throws DataAccessException;

	Map<String, Integer> getBuyersByItemId(String itemId) throws DataAccessException;

	List<AuctionItem> getAllAuctionItemByUserId(String userId) throws DataAccessException;

	List<AuctionItem> getAuctionItem(String userId) throws DataAccessException;

	int calcBestPrice(String itemId) throws DataAccessException;

	void insertAuctionItem(AuctionItem auctionItem) throws DataAccessException;

	void updatePrice(String userId) throws DataAccessException;

	void deleteAuctionItem(String itemId) throws DataAccessException;

	List<AuctionItem> getAuctionedItem(String userId) throws DataAccessException;

	List<AuctionItem> getOrderedItem(String userId) throws DataAccessException;

	int countAuctionJoinList(String userId) throws DataAccessException;

	void changeState(String userId, String itemId) throws DataAccessException;
	
	void updateReload(String itemId, int minPrice, Date deadline) throws DataAccessException;
	
}
