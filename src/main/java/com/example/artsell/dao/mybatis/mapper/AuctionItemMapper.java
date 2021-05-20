package com.example.artsell.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import com.example.artsell.domain.AuctionItem;

@Mapper
public interface AuctionItemMapper {
	AuctionItem getAuctionItemByItemIdAndUserId(String itemId, String userId) throws DataAccessException;
}
