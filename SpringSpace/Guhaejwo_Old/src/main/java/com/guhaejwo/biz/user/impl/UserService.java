package com.guhaejwo.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guhaejwo.biz.user.LoginType;
import com.guhaejwo.biz.user.Role;
import com.guhaejwo.biz.user.UserDTO;
import com.guhaejwo.biz.user.UserRepository;

@Service("userService")
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	// 일반회원가입
	public String join(UserDTO user) {
		user.setLoginType(LoginType.BASIC);
		user.setUserRole(Role.USER);

		userRepository.save(user);
		return user.getUserId();
	}
	
	// 카카오회원가입
	public String join_kakao(UserDTO user) {
		user.setLoginType(LoginType.KAKAO);
		user.setUserRole(Role.USER);
	
		userRepository.save(user);
		return user.getUserId();
	}
	
	// 일반회원탈퇴
	public void withdraw(UserDTO user) {
		userRepository.delete(user);
	}
	
	// 회원 검색(ID)
	public UserDTO findById(UserDTO user) {
		return userRepository.getUserById(user);
	}
	
	// 회원 검색(ID & Email)
	public UserDTO findByEmail(UserDTO user) {
		return userRepository.getUserByEmail(user);
	}
}
