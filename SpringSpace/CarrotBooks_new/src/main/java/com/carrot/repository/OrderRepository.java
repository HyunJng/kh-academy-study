package com.carrot.repository;

import java.util.List;

import com.carrot.domain.BookVO;
import com.carrot.domain.CartVO;
import com.carrot.domain.Criteria;
import com.carrot.domain.MemberVO;
import com.carrot.domain.OrderItemVO;
import com.carrot.domain.OrderPageItemVO;
import com.carrot.domain.OrderVO;

public interface OrderRepository {

	// 주문 상품 정보(주문 페이지)
	public OrderPageItemVO getGoodsInfo(OrderPageItemVO orderItem);
	
	// 주문 상품 정보(주문 처리)
	public OrderItemVO getOrderInfo(String bookId);
	
	// 주문 테이블 등록
	public int enrollOrder(OrderVO order);
	
	// 주문 아이템 테이블 등록
	public int enrollOrderItem(OrderItemVO orderItem);
	
	// 포인트 차감
	public int deductPoint(MemberVO member);
	
	// 상품 재고 차감
	public int deductStock(BookVO book);
	
	// 카트 제거
	public int deleteOrderCart(CartVO cart);
	
	// 주문 상품 리스트(ALL)
	public List<OrderVO> getOrderList(Criteria cri);
	
	// 주문 총 개수(ALL)
	public int getOrderTotal(Criteria cri);
}
