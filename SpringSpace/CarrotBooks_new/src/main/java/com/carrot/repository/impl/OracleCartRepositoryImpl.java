package com.carrot.repository.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carrot.domain.CartVO;
import com.carrot.domain.MemberVO;
import com.carrot.repository.CartRepository;

@Repository("cartRepository")
public class OracleCartRepositoryImpl implements CartRepository{

	private SqlSessionTemplate mybatis;
	
	@Autowired
	public OracleCartRepositoryImpl(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	@Override
	public int addCart(CartVO cart) throws Exception {
		return mybatis.insert("CartMapper.insertCart", cart);
	}

	@Override
	public int deleteCart(CartVO cart) {
		return mybatis.delete("CartMapper.deleteCart", cart);
	}

	@Override
	public int modifyCount(CartVO cart) {
		return mybatis.update("CartMapper.modifyCount", cart);
	}

	@Override
	public List<CartVO> getCart(MemberVO member) {
		return mybatis.selectList("CartMapper.getCart", member);
	}

	@Override
	public CartVO checkCart(CartVO cart) {
		return mybatis.selectOne("CartMapper.checkCart", cart);
	}
	
}
