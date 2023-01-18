package com.guhaejwo.biz.user;

import java.util.List;

public interface UserRepository {
	
	// 회원저장
	public void save(UserDTO user);
	
	// 회원 삭제
	public void delete(UserDTO user);
	
	// 회원 검색
	public UserDTO getUserById(UserDTO user);
	
	// id&이메일로 회원 검색
	public UserDTO getUserByEmail(UserDTO user);
	
	// 회원 리스트 가져오기
	public List<UserDTO> getUserList();
	
}
