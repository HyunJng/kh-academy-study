package com.guhaejwo.biz.user.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guhaejwo.biz.user.UserDTO;
import com.guhaejwo.biz.user.UserRepository;

@Repository("userRepository")
public class MybatisUserRepositoryImpl implements UserRepository{

	private final SqlSessionTemplate mybatis;
	
	@Autowired
	public MybatisUserRepositoryImpl(SqlSessionTemplate mybatis) { 
		this.mybatis = mybatis; 
	}
	
	@Override
	public void save(UserDTO user) {
		System.out.println("---> MybatisUserRepository.save() 실행");
		mybatis.insert("UserDAO.insertUser", user);
		// System.out.println("---> MybatisUserRepository.save() 완료");
	}
	
	@Override
	public void delete(UserDTO user) {
		System.out.println("---> MybatisUserRepository.delete() 실행");
		mybatis.delete("UserDAO.deleteUser", user);
		//System.out.println("---> MybatisUserRepository.delete() 완료");
	}

	@Override
	public UserDTO getUserById(UserDTO user) {
		System.out.println("--> MybatisUserRepository.getUser() 실행");
		return mybatis.selectOne("UserDAO.getUserById", user);
	}
	
	@Override
	public UserDTO getUserByEmail(UserDTO user) {
		System.out.println("--> MybatisUserRepository.getUserByEmail() 실행");
		return mybatis.selectOne("UserDAO.getUserByEmail", user);
	}

	@Override
	public List<UserDTO> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

}
