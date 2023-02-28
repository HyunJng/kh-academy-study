package com.carrot.repository.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carrot.domain.OrderItemVO;
import com.carrot.repository.OrderRepository;

@Repository("orderRepository")
public class OracleOrderRepository implements OrderRepository{
	
	@Autowired private SqlSessionTemplate mybatis;

	@Override
	public OrderItemVO getGoodsInfo(OrderItemVO orderItem) {
		return mybatis.selectOne("OrderMapper.getGoodsInfo", orderItem);
	}
	
}
