package com.carrot.domain;

import java.util.List;

public class OrderVO {

	private List<OrderItemVO> orders;

	public List<OrderItemVO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderItemVO> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "OrderVO [orders=" + orders + "]";
	}
	
}
