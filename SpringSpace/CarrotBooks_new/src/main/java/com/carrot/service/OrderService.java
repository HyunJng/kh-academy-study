package com.carrot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrot.domain.OrderPageItemVO;
import com.carrot.repository.MemberRepository;
import com.carrot.repository.OrderPageRepository;
import com.carrot.repository.OrderPageRepository;

@Service
public class OrderService {

	private OrderPageRepository orderPageRepository;
	
	@Autowired
	public OrderService(OrderPageRepository orderPageRepository) {
		this.orderPageRepository = orderPageRepository;
	}
	
	// 주문리스트 정보 가져오기
	public List<OrderPageItemVO> getGoodsInfo(List<OrderPageItemVO> orders){
		List<OrderPageItemVO> result = new ArrayList<>();
		
		for(OrderPageItemVO order: orders) {
			OrderPageItemVO info = orderPageRepository.getGoodsInfo(order);
			info.setBookCount(order.getBookCount());
			info.initSaleTotal();
			
			result.add(info);
		}
		
		return result;
	}
	
}
