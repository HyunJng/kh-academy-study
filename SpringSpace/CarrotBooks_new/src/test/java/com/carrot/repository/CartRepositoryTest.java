package com.carrot.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.carrot.domain.CartVO;
import com.carrot.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class CartRepositoryTest {

	@Autowired private CartRepository cartRepository;
	
	/*
	@Test
	public void 카트추가() {
		CartVO cart = new CartVO();
		String bookId = "1196168075 9791196168070";
		int memberId = 22;
		int count = 3;
		
		cart.setBookId(bookId);
		cart.setBookCount(count);
		cart.setMemberId(memberId);
		
		int result = 0;
		result = cartRepository.addCart(cart);
		System.out.println(result);
	}
	
	@Test
	public void 카트삭제() {
		CartVO cart = new CartVO();
		cart.setCartId(2);
		
		int result = 0;
		result = cartRepository.deleteCart(cart);
		System.out.println(result);
	}

	@Test
	public void 카트수량수정() {
		CartVO cart = new CartVO();
		int newCount = 5;
		cart.setCartId(3);
		cart.setBookCount(newCount);
		
		int result = 0;
		result = cartRepository.modifyCount(cart);
		System.out.println(result);
	}
	
	@Test
	public void 카트목록() {
		int memberId = 22;
		
		List<CartVO> list = cartRepository.getCart(memberId);
		list.forEach(cart -> System.out.println(cart));
	}
	 * */
}
