package com.example.artsell.dao.mybatis.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import com.example.artsell.domain.AuctionItem;

@Mapper
public interface AuctionItemMapper {
	AuctionItem getAuctionItemByItemIdAndUserId(String itemId, String userId) throws DataAccessException;

	Map<String, Integer> getBuyersByItemId(String itemId) throws DataAccessException;
}
