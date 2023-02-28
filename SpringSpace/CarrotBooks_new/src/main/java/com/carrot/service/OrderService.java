package com.carrot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrot.domain.OrderItemVO;
import com.carrot.repository.MemberRepository;
import com.carrot.repository.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepository;
	
	@Autowired
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	// 주문리스트 정보 가져오기
	public List<OrderItemVO> getGoodsInfo(List<OrderItemVO> orders){
		List<OrderItemVO> result = new ArrayList<>();
		
		for(OrderItemVO order: orders) {
			OrderItemVO info = orderRepository.getGoodsInfo(order);
			info.setBookCount(order.getBookCount());
			info.initSaleTotal();
			
			result.add(info);
		}
		
		return result;
	}
	
}
