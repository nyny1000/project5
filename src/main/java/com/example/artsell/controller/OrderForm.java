package com.example.artsell.controller;

import java.io.Serializable;

import com.example.jpetstore.domain.Order;

@SuppressWarnings("serial")
public class OrderForm implements Serializable {

	private final Order order = new Order();

	public Order getOrder() {
		return order;
	}
}
