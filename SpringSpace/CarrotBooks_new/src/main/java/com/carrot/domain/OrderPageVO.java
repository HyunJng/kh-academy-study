package com.carrot.domain;

import java.util.List;

public class OrderPageVO {

	private List<OrderPageItemVO> orders;
	private OrderVO orderInfo;
	
	public List<OrderPageItemVO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderPageItemVO> orders) {
		this.orders = orders;
	}

	public OrderVO getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderVO orderInfo) {
		this.orderInfo = orderInfo;
	}

	public void setTotalPrice() {
		int priceSum = 0, pointSum = 0;
		for(OrderPageItemVO order : orders) {
			priceSum += order.getTotalPrice();
			pointSum += order.getTotalPoint();
		}
		orderInfo.setOrderSalePrice(priceSum);
		orderInfo.setOrderSavePoint(pointSum);
	}
	
	@Override
	public String toString() {
		return "OrderPageVO [orders=" + orders + ", orderInfo=" + orderInfo + "]";
	}

}
