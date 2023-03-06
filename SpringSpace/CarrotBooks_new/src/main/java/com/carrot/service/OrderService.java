package com.carrot.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carrot.domain.BookVO;
import com.carrot.domain.CartVO;
import com.carrot.domain.MemberVO;
import com.carrot.domain.OrderCancleVO;
import com.carrot.domain.OrderItemVO;
import com.carrot.domain.OrderPageItemVO;
import com.carrot.domain.OrderVO;
import com.carrot.repository.BookRepository;
import com.carrot.repository.CartRepository;
import com.carrot.repository.MemberRepository;
import com.carrot.repository.OrderRepository;
import com.carrot.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired private OrderRepository orderRepository;
	@Autowired private MemberRepository memberRepository;
	@Autowired private BookRepository bookRepository;
	
	// 주문리스트 정보 가져오기
	public List<OrderPageItemVO> getGoodsInfo(List<OrderPageItemVO> orders){
		List<OrderPageItemVO> result = new ArrayList<>();
		
		for(OrderPageItemVO order: orders) {
			OrderPageItemVO info = orderRepository.getGoodsInfo(order);
			info.setBookCount(order.getBookCount());
			info.initSaleTotal();
			
			result.add(info);
		}
		
		return result;
	}
	
	// 주문 처리
	@Transactional
	public void order(OrderVO order) {
		// 회원정보
		MemberVO memberInfo= new MemberVO();
		memberInfo.setMemberId(order.getMemberId());
		MemberVO member = memberRepository.findMemberbyId(memberInfo);
		
		// 주문정보
		List<OrderItemVO> ords = new ArrayList<>();
		for(OrderItemVO oi : order.getOrders()) {
			OrderItemVO orderItem = orderRepository.getOrderInfo(oi.getBookId());
			orderItem.setBookCount(oi.getBookCount());
			orderItem.initSaleTotal();
			ords.add(orderItem);
		}
		order.setOrders(ords);
		order.getOrderPriceInfo();

		// 배송정보
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("_yyyyMMddhhmmss");
		String orderId = member.getMemberId() + sdf.format(date);
		order.setOrderId(orderId);

		// DB넣기
		orderRepository.enrollOrder(order);
		for(OrderItemVO oi : order.getOrders()) {
			oi.setOrderId(orderId);
			orderRepository.enrollOrderItem(oi);
		}

		// 포인트 변동
		int calPoint = member.getMemberPoint();
		calPoint = calPoint - order.getUsePoint() + order.getOrderSavePoint();
		member.setMemberPoint(calPoint);
		
		// DB 변경
		orderRepository.updatePoint(member);
		
		// 재고 변동
		for(OrderItemVO oi : order.getOrders()) {
			BookVO bookInfo = new BookVO();
			bookInfo.setBookId(oi.getBookId());
			
			BookVO book = bookRepository.getBookById(bookInfo);
			book.setBookStock(book.getBookStock() - oi.getBookCount());
			
			orderRepository.updateStock(book);
		}
		// 장바구니 제거
		for(OrderItemVO oi : order.getOrders()) {
			CartVO cart = new CartVO();
			cart.setMemberId(order.getMemberId());
			cart.setBookId(oi.getBookId());
			
			orderRepository.deleteOrderCart(cart);
		}
	}
	
	@Transactional
	public void orderCancle(OrderCancleVO vo) {
		// 회원 정보 가져오기
		MemberVO memberInfo = new MemberVO();
		memberInfo.setMemberId(vo.getMemberId());
		MemberVO member = memberRepository.findMemberbyId(memberInfo);
		
		System.out.println("서비스 member: " + member);
		
		// 주문 상세 정보 가져오기
		List<OrderItemVO> ords = orderRepository.getOrderItemInfo(vo.getOrderId());
		for(OrderItemVO temp : ords) {
			temp.initSaleTotal();
		}

		System.out.println("서비스 주문 상세정보 : " + ords);
		
		// 주문 정보 가져오기
		OrderVO orw = orderRepository.getOrder(vo.getOrderId());
		orw.setOrders(ords);
		orw.getOrderPriceInfo();
		
		System.out.println("서비스 주문정보: " + orw);
		/*
		 * */
		// 주문 상태 변경
		orderRepository.orderCancle(orw.getOrderId());

		// 포인트 반환
		int calPoint = member.getMemberPoint();
		calPoint = calPoint + orw.getUsePoint() - orw.getOrderSavePoint();
		member.setMemberPoint(calPoint);
		
		orderRepository.updatePoint(member);
		
		// 재고 반환
		for(OrderItemVO ord : orw.getOrders()) {
			BookVO bookInfo = new BookVO();
			bookInfo.setBookId(ord.getBookId());
			BookVO book = bookRepository.getBookById(bookInfo);
			book.setBookStock(book.getBookStock() + ord.getBookCount());
			orderRepository.updateStock(book);
		}
				
	}
	
	
}
