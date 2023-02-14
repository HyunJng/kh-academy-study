package com.dadok.repository.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dadok.domain.BookVO;
import com.dadok.domain.Criteria;
import com.dadok.repository.BookRepository;

@Repository("bookRepository")
public class OracleBookRepositoryImpl implements BookRepository{

	private final SqlSessionTemplate mybatis;
	
	@Autowired
	public OracleBookRepositoryImpl(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}
	
	@Override
	public void save(BookVO book) throws Exception{
		mybatis.insert("BookMapper.insertBook", book);
	}

	@Override
	public List<BookVO> getBookList(Criteria cri) {
		return mybatis.selectList("BookMapper.getBookList", cri);
	}

	@Override
	public int getTotal() {
		return mybatis.selectOne("BookMapper.getTotal");
	}
	
	
	
}
