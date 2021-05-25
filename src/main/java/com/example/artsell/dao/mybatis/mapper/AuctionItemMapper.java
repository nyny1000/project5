package com.example.artsell.dao.mybatis.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.artsell.domain.AuctionItem;
import com.example.artsell.domain.AuctionedItem;

@Mapper
public interface AuctionItemMapper {
	AuctionItem getAuctionItemByItemIdAndUserId(String itemId, String userId);

	List<AuctionItem> getBuyersByItemId(String itemId);

	List<AuctionItem> getAllAuctionItemByUserId(String userId);

	List<AuctionItem> getAuctionItem(String userId);

	int calcBestPrice(String itemId);

	void insertAuctionItem(AuctionItem auctionItem);

	void updatePrice(String userId, String itemId, int price);

	void deleteAuctionItem(String userId, String itemId);
	
	void updateItemBestPrice(String itemId, int price);
	
	void addPrice(String userId, String itemId, int price);

	List<AuctionItem> getAuctionedItem(String userId);

	List<AuctionItem> getOrderedItem(String userId);
	
	int isNewUserPrice(String userId, String itemId);

	int countAuctionJoinList(String userId);

	void changeState(String userId, String itemId, int state);
	
	List<AuctionItem> getItemListByAuctionItem(String userId);
	
	List<AuctionedItem> getItemListByAuctionedItem(String userId);

}
