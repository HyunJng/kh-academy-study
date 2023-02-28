package com.carrot.repository;

import com.carrot.domain.OrderItemVO;

public interface OrderRepository {

	// 주문 상품 정보
	public OrderItemVO getGoodsInfo(OrderItemVO orderItem);
	
}
