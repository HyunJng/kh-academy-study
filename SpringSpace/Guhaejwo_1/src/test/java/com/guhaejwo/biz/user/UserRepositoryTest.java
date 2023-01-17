package com.guhaejwo.biz.user;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
@ContextConfiguration(locations = {"file:src/main/resources/applicationContext.xml"})
public class UserRepositoryTest {

	@Autowired UserRepository userRepository;
	
/*	
	@Test
	public void 멤버정상가입() {
		UserDTO user1 = new UserDTO();
		user1.setUserName("김길동");
		user1.setUserId("user1");
		user1.setUserPw("1234");
		user1.setUserAlias("kim");
		user1.setUserEmail("kkk@naver.com");
		//user1.setUserAddr("서울특별시");
		user1.setUserPhone("01053728706");
		user1.setUserRole(Role.ADMIN);
		//user1.setUserImage("이미지");
		userRepository.save(user1);		
	}
*/

/*
	@Test
	public void 회원삭제() {
		UserDTO user1 = new UserDTO();
		user1.setUserSeq(1L);
		userRepository.delete(user1);
	}
 */
/*

	@Test
	public void 회원조회() {
		UserDTO user = new UserDTO();
		user.setUserId("user1");
		
		user = userRepository.getUserById(user);
		System.out.println("김길동 = " + user.getUserPw());
	}
 */
}
