package com.example.artsell.dao.mybatis;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.artsell.dao.AuctionItemDao;
import com.example.artsell.dao.mybatis.mapper.AuctionItemMapper;
import com.example.artsell.domain.AuctionItem;

@Repository
public class MybatisAuctionItemDao implements AuctionItemDao {
	@Autowired
	private AuctionItemMapper auctionItemMapper;

	@Override
	public Map<String, Integer> getBuyersByItemId(String itemId) throws DataAccessException {
		// TODO Auto-generated method stub

		List<AuctionItem> list = auctionItemMapper.getBuyersByItemId(itemId);
		Map<String, Integer> buyer = new HashMap<String, Integer>();
		for (int i = 0; i < list.size(); i++) {
			buyer.put(list.get(i).getUserId(), list.get(i).getMyPrice());
		}
		return buyer;
	}

	@Override
	public List<AuctionItem> getAllAuctionItemByUserId(String userId) throws DataAccessException {
		return auctionItemMapper.getAllAuctionItemByUserId(userId);
	}

	@Override
	public AuctionItem getAuctionItemByItemIdAndUserId(String itemId, String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionItemMapper.getAuctionItemByItemIdAndUserId(itemId, userId);
	}

	@Override
	public List<AuctionItem> getAuctionItem(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionItemMapper.getAuctionItem(userId);
	}

	@Override
	public int calcBestPrice(String itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionItemMapper.calcBestPrice(itemId);
	}

	@Override
	public void insertAuctionItem(AuctionItem auctionItem) throws DataAccessException {
		// TODO Auto-generated method stub
		auctionItemMapper.insertAuctionItem(auctionItem);

	}

	@Override
	public void updatePrice(String userId, String itemId, int price) throws DataAccessException {
		// TODO Auto-generated method stub
		auctionItemMapper.updatePrice(userId, itemId, price);
	}

	@Override
	public void updateItemBestPrice(String itemId, int price) throws DataAccessException {
		auctionItemMapper.updateItemBestPrice(itemId, price);
	}
	
	@Override
	public void deleteAuctionItem(String itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		auctionItemMapper.deleteAuctionItem(itemId);
	}
	
	@Override
	public void addPrice(String userId, String itemId, int price) throws DataAccessException {
		auctionItemMapper.addPrice(userId, itemId, price);
	}

	@Override
	public int isNewUserPrice(String userId, String itemId) throws DataAccessException {
		return auctionItemMapper.isNewUserPrice(userId, itemId);
	}
	
	@Override
	public List<AuctionItem> getAuctionedItem(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionItemMapper.getAuctionItem(userId);
	}

	@Override
	public List<AuctionItem> getOrderedItem(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionItemMapper.getOrderedItem(userId);
	}

	@Override
	public int countAuctionJoinList(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionItemMapper.countAuctionJoinList(userId);
	}

	@Override
	public void changeState(String userId, String itemId, int state) throws DataAccessException {
		// TODO Auto-generated method stub
		auctionItemMapper.changeState(userId, itemId, state);
	}

}
