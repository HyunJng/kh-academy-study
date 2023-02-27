package com.carrot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrot.domain.CartVO;
import com.carrot.domain.MemberVO;
import com.carrot.repository.CartRepository;

@Service
public class CartService {

	private CartRepository cartRepository;
	
	@Autowired
	public CartService(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	// 카트 추가
	public int addCart(CartVO cart) {
		// 기존 것이 존재하는지 체크
		CartVO checkCart = cartRepository.checkCart(cart);
		
		if(checkCart != null) { // 이미 존재함
			return 2;
		}
		
		try {
			return cartRepository.addCart(cart); // 성공시 1 반환
		} catch (Exception e) {
			return 0;
		}
	}
	
	// 장바구니 리스트 가져오기
	public List<CartVO> getCartList(MemberVO member){
		List<CartVO> cart = cartRepository.getCart(member);
		// DB에 없는 값들 초기화
		for(CartVO vo: cart) {
			vo.initSaleTotal();
		}
		return cart;
	}
	
	// 카트 수량 수정
	public int modifyCount(CartVO cart) {
		return cartRepository.modifyCount(cart);
	}
}
