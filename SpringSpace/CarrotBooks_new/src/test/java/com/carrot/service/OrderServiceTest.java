package com.carrot.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.carrot.domain.CartVO;
import com.carrot.domain.OrderPageItemVO;
import com.carrot.domain.OrderVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class OrderServiceTest {

	@Autowired private OrderService orderService;
	
	@Test
	public void 주문정보Get() {
		String orderId = "22_20230306011000";
		OrderVO vo = orderService.getOrderInfobyOrderId(orderId);
		List<OrderPageItemVO> list = orderService.getOrderItemListbyOrderId(orderId);
		
		System.out.println(vo);
		System.out.println(list);
	}
	

}
