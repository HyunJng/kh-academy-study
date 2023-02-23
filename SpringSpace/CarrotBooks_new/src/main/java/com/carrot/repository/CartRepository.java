package com.carrot.repository;

import java.util.List;

import com.carrot.domain.CartVO;
import com.carrot.domain.MemberVO;

public interface CartRepository {
	
	// 카트 추가(1성공 0실패)
	public int addCart(CartVO cart) throws Exception;
	
	// 카트 삭제(1성공 0실패)
	public int deleteCart(CartVO cart);
	
	// 카트 수량 수정(1성공 0실패)
	public int modifyCount(CartVO cart);
	
	// 카트 목록
	public List<CartVO> getCart(int memberId);
	
	// 카트 확인
	public CartVO checkCart(CartVO cart); 
}
