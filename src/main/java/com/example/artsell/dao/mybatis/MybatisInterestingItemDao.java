package com.example.artsell.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.artsell.dao.InterestingItemDao;
import com.example.artsell.dao.mybatis.mapper.InterestingItemMapper;
import com.example.artsell.domain.Item;

@Repository
public class MybatisInterestingItemDao implements InterestingItemDao {
	
	@Autowired
	private InterestingItemMapper interestingItemMapper;
	
	public List<Item> getInterestingItemList(String userId) throws DataAccessException {
		return interestingItemMapper.getInterestingItemList(userId);
	}
	
	public void insertInterestingItem(String userId, String itemId) throws DataAccessException {
		interestingItemMapper.insertInterestingItem(userId, itemId);
	}
	
	public void deleteInterestingItem(String userId, String itemId) throws DataAccessException {
		interestingItemMapper.deleteInterestingItem(userId, itemId);
	}
	
	public int containsInterestingItem(String userId, String itemId) throws DataAccessException {
		return interestingItemMapper.containsInterestingItem(userId, itemId);
	}
}
