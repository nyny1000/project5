package com.example.artsell.dao.mybatis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.artsell.dao.AuctionItemDao;
import com.example.artsell.dao.mybatis.mapper.AuctionItemMapper;

@Repository
public class MybatisAuctionItemDao implements AuctionItemDao {
	@Autowired
	private AuctionItemMapper aucitonItemMapper;

	@Override
	public Map<String, Integer> getBuyersByItemId(String itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionItemMapper.;
	}
}
