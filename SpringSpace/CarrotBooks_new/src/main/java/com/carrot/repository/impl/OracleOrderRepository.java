package com.carrot.repository.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carrot.domain.BookVO;
import com.carrot.domain.CartVO;
import com.carrot.domain.Criteria;
import com.carrot.domain.MemberVO;
import com.carrot.domain.OrderItemVO;
import com.carrot.domain.OrderPageItemVO;
import com.carrot.domain.OrderVO;
import com.carrot.repository.OrderRepository;

@Repository("orderRepository")
public class OracleOrderRepository implements OrderRepository{
	
	@Autowired private SqlSessionTemplate mybatis;

	@Override
	public OrderPageItemVO getGoodsInfo(String bookId) {
		return mybatis.selectOne("OrderMapper.getGoodsInfo", bookId);
	}

	@Override
	public OrderItemVO getOrderInfo(String bookId) {
		return mybatis.selectOne("OrderMapper.getOrderInfo", bookId);
	}

	@Override
	public int enrollOrder(OrderVO order) {
		return mybatis.insert("OrderMapper.enrollOrder", order);
	}

	@Override
	public int enrollOrderItem(OrderItemVO orderItem) {
		return mybatis.insert("OrderMapper.enrollOrderItem", orderItem);
	}

	@Override
	public int updatePoint(MemberVO member) {
		return mybatis.update("OrderMapper.updatePoint", member);
	}

	@Override
	public int updateStock(BookVO book) {
		return mybatis.update("OrderMapper.updateStock", book);
	}

	@Override
	public int deleteOrderCart(CartVO cart) {
		return mybatis.delete("OrderMapper.deleteOrderCart", cart);
	}

	@Override
	public List<OrderVO> getOrderList(Criteria cri) {
		return mybatis.selectList("OrderMapper.getOrderList", cri);
	}

	@Override
	public int getOrderTotal(Criteria cri) {
		return mybatis.selectOne("OrderMapper.getOrderTotal", cri);
	}

	@Override
	public int orderCancle(String orderId) {
		return mybatis.update("OrderMapper.orderCancle", orderId);
	}

	@Override
	public List<OrderItemVO> getOrderItemInfo(String orderId) {
		return mybatis.selectList("OrderMapper.getOrderItemInfo", orderId);
	}

	@Override
	public OrderVO getOrder(String orderId) {
		return mybatis.selectOne("OrderMapper.getOrder", orderId);
	}
	
	
}
