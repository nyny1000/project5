package com.example.artsell.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.artsell.dao.OrderDao;
import com.example.artsell.dao.mybatis.mapper.AuctionItemMapper;
import com.example.artsell.dao.mybatis.mapper.OrderMapper;
import com.example.artsell.domain.Order;

@Repository
public class MybatisOrderDao implements OrderDao {
	@Autowired
	protected OrderMapper orderMapper;

	@Autowired
	protected AuctionItemMapper auctionItemMapper;

	@Transactional
	public Order getOrder(String itemId, String userId) throws DataAccessException {
		//AuctionItem auctionItem = orderMapper.getAuctionItem(itemId, userId);
		Order order = orderMapper.getOrder(itemId, userId);
		if (order != null) {
			//order.setLineItems(lineItemMapper.getLineItemsByOrderId(itemId));
			order.setAuctionItem(auctionItemMapper.getAuctionItemByItemIdAndUserId(itemId, userId));
		}
	    return order;
	}
	@Transactional
	public void editDestination(Order order, String des) throws DataAccessException {
		order.setDestination(des);
		orderMapper.editDestination(order, des);
	}
	@Transactional
	public void SaveAuctionedItem (Order order) throws DataAccessException {
		if (order != null) {
			orderMapper.SaveAuctionedItem(order);
		}
	}
}
