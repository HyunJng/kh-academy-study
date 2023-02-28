package com.carrot.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.carrot.domain.OrderItemVO;

@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class OrderRepositoryTest {
	
	@Autowired OrderRepository orderRepository;
	
	@Test
	public void orderItem가져오기() {
		String bookId = "119815960X 9791198159601";
		OrderItemVO orderItem = new OrderItemVO();
		orderItem.setBookId(bookId);
		
		orderItem = orderRepository.getGoodsInfo(orderItem);
		
		System.out.println(orderItem);
	}
	
}
