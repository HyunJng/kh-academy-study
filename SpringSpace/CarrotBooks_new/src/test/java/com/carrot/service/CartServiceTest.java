package com.carrot.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.carrot.domain.CartVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class CartServiceTest {

	@Autowired private CartService cartService;
	
	@Test
	public void 카트추가() {
		int memberId = 22;
		String bookId = "1191043290 9791191043297";
		int count = 3;
		
		CartVO cart = new CartVO();
		cart.setBookCount(count);
		cart.setBookId(bookId);
		cart.setMemberId(memberId);
		
		int result = cartService.addCart(cart);
		
		System.out.println("result : " + result);
	}

}
