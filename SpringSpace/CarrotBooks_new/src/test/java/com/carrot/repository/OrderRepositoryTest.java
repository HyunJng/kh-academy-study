package com.carrot.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.carrot.domain.BookVO;
import com.carrot.domain.CartVO;
import com.carrot.domain.Criteria;
import com.carrot.domain.MemberVO;
import com.carrot.domain.OrderItemVO;
import com.carrot.domain.OrderPageItemVO;
import com.carrot.domain.OrderVO;

@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class OrderRepositoryTest {
	
	@Autowired OrderRepository orderRepository;
/*
	@Test
	public void orderItem가져오기() {
		String bookId = "119815960X 9791198159601";
		OrderPageItemVO orderItem = new OrderPageItemVO();
		orderItem.setBookId(bookId);
		
		orderItem = orderRepository.getGoodsInfo(orderItem);
		
		System.out.println(orderItem);
	}
	
	@Test
	public void getOrderInfoTest() {
		String bookId = "119815960X 9791198159601";
		OrderItemVO orderItem = orderRepository.getOrderInfo(bookId);
		System.out.println(orderItem);
	}
	@Test
	public void enrollOrderTest() {
		OrderVO order = new OrderVO();
		List<OrderItemVO> orders = new ArrayList<>();
		
		OrderItemVO order1 = new OrderItemVO();
		order1.setBookId("119815960X 9791198159601");
		order1.setBookCount(1);
		order1.setBookPrice(10000);
		order1.setDiscountPer(10);
		order1.initSaleTotal();
		
		orders.add(order1);
		order.setOrders(orders);
		
		order.setOrderId("2023_test1");
		order.setAddressee("test");
		order.setMemberId(22);
		order.setMemberAddr1("test");
		order.setMemberAddr2("test");
		order.setMemberAddr3("test");
		order.setOrderState("배송중비");
		order.getOrderPriceInfo();
		order.setUsePoint(1000);
		
		orderRepository.enrollOrder(order);
	}
	@Test 
	public void enrollOrderItemTest() {
		OrderItemVO oid = new OrderItemVO();
		
		oid.setOrderId("2023_test1");
		oid.setBookId("119815960X 9791198159601");
		oid.setBookCount(1);
		oid.setBookPrice(10000);
		oid.setDiscountPer(10);
		oid.initSaleTotal();
		
		orderRepository.enrollOrderItem(oid);
	}
	
	@Test
	public void deductPointTest() {
		MemberVO member = new MemberVO();
		member.setMemberId(22);
		member.setMemberPoint(7000);
		
		orderRepository.deductPoint(member);
	}
	@Test
	public void deductStockTest() {
		BookVO book = new BookVO();
		
		book.setBookId("119815960X 9791198159601");
		book.setBookStock(3);
		orderRepository.deductStock(book);
	}
	
	@Test
	public void deleteOrderCart() {
		CartVO cart = new CartVO();
		cart.setMemberId(22);
		cart.setBookId("8959136417 9788959136414");
		
		orderRepository.deleteOrderCart(cart);
	}
 * */
	@Test
	public void getOrderListTest() {
		Criteria cri = new Criteria();
		cri.setKeyword("22");
		List<OrderVO> list = orderRepository.getOrderList(cri);
		System.out.println(list);
	}
}
