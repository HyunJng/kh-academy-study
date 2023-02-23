package com.carrot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrot.domain.CartVO;
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
}
