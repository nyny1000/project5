package com.example.artsell.dao.mybatis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.artsell.dao.ItemDao;
import com.example.artsell.dao.mybatis.mapper.InterestingItemMapper;
import com.example.artsell.dao.mybatis.mapper.ItemMapper;
import com.example.artsell.domain.Item;

@Repository
public class MybatisItemDao implements ItemDao {
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private InterestingItemMapper interestingItemMapper;
	
	public Item getItem(String itemId) throws DataAccessException {
		return itemMapper.getItem(itemId);
	}

	public List<Item> searchItemList(String keywords, String artist, String categoryId) throws DataAccessException {
		// TODO Auto-generated method stub
		if ("".equals(keywords)) {
			keywords = null;
		}
		return itemMapper.searchItemList(keywords, artist, categoryId);
	}

	public List<Item> getItemListByCategory(String categoryId) throws DataAccessException {
		// TODO Auto-generated method stub
		return itemMapper.getItemListByCategory(categoryId);
	}

	public List<Item> getItemListByUserId(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return itemMapper.getItemListByUserId(userId);
	}

	public List<Item> getMyItemList(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return itemMapper.getMyItemList(userId);
	}
	
	//경매참여자가 한명도 없을때만 취소 가능
	public void deleteItem(String userId, String itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		itemMapper.deleteItem(itemId);
		interestingItemMapper.deleteInterestingItem(userId, itemId);
	}

	public void insertItem(Item item) throws DataAccessException {
		// TODO Auto-generated method stub
		itemMapper.insertItem(item);
	}

	public void updateItem(String itemId, String price) throws DataAccessException {
		// TODO Auto-generated method stub
		itemMapper.updateItemPrice(itemId, price);
	}

	public void updateReload(String itemId, int minPrice, Date deadline) throws DataAccessException {
		// TODO Auto-generated method stub
		itemMapper.updateReload(itemId, minPrice, deadline);
	}
	
	/* Inner Classes */
	public static class ItemSearch {

		private List<String> keywordList = new ArrayList<String>();

		public ItemSearch(String keywords) {
			StringTokenizer splitter = new StringTokenizer(keywords," ",false);
			while (splitter.hasMoreTokens()) {
				this.keywordList.add("%" + splitter.nextToken() + "%");
			}
		}
		public List<String> getKeywordList() {
			return keywordList;
		}
	}

	@Override
	public List<String> getArtistList() throws DataAccessException {
		// TODO Auto-generated method stub
		return itemMapper.getArtistList();
	}
}
