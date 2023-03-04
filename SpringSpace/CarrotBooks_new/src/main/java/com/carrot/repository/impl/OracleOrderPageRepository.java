package com.carrot.repository.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carrot.domain.OrderPageItemVO;
import com.carrot.repository.OrderPageRepository;

@Repository("orderPageRepository")
public class OracleOrderPageRepository implements OrderPageRepository{
	
	@Autowired private SqlSessionTemplate mybatis;

	@Override
	public OrderPageItemVO getGoodsInfo(OrderPageItemVO orderItem) {
		return mybatis.selectOne("OrderPageMapper.getGoodsInfo", orderItem);
	}
	
}
