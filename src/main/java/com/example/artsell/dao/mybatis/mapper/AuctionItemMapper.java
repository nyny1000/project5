package com.example.artsell.dao.mybatis.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import com.example.artsell.domain.AuctionItem;

@Mapper
public interface AuctionItemMapper {
	AuctionItem getAuctionItemByItemIdAndUserId(String itemId, String userId);

	List<AuctionItem> getBuyersByItemId(String itemId);

	List<AuctionItem> getAllAuctionItemByUserId(String userId);

	List<AuctionItem> getAuctionItem(String userId);

	int calcBestPrice(String itemId);

	void insertAuctionItem(AuctionItem auctionItem);

	void updatePrice(String userId);

	void deleteAuctionItem(String itemId);

	List<AuctionItem> getAuctionedItem(String userId);

	List<AuctionItem> getOrderedItem(String userId);

	int countAuctionJoinList(String userId);


	void changeState(String userId, String itemId, int state);

}
