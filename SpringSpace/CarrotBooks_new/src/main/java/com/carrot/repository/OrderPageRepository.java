package com.carrot.repository;

import com.carrot.domain.OrderPageItemVO;

public interface OrderPageRepository {

	// 주문 상품 정보
	public OrderPageItemVO getGoodsInfo(OrderPageItemVO orderItem);
	
}
