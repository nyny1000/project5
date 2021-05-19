package com.example.artsell.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.artsell.domain.Item;

public interface InterestingItemMapper {
	List<Item> getInterestingItemList(String userId);
	
	void insertInterestingItem(String userId, String itemId);
	
	void deleteInterestingItem(String userId, String itemId);
	
	int containsInterestingItem(String userId, String itemId);
	
}
