package com.guhaejwo.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guhaejwo.biz.user.UserDTO;
import com.guhaejwo.biz.user.UserRepository;

@Service("userService")
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	// 회원가입
	public String join(UserDTO user) {
		// 중복회원 검사(Front에서 할건가?)
		userRepository.save(user);
		return user.getUserId();
	}
	
	// 회원탈퇴
	public void withdraw(UserDTO user) {
		userRepository.delete(user);
	}
	
	// 회원 수정
	
	
	// 회원 검색(ID)
	public UserDTO findById(UserDTO user) {
		return userRepository.getUser(user);
	}
}
