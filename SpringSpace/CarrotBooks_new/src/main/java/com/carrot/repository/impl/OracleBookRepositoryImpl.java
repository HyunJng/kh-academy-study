package com.carrot.repository.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carrot.domain.BCateVO;
import com.carrot.domain.BookVO;
import com.carrot.domain.Criteria;
import com.carrot.repository.BookRepository;

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
	public void delete(BookVO book) {
		mybatis.delete("BookMapper.deleteBook", book);	
	}

	@Override
	public BookVO getBookById(BookVO book) {
		return mybatis.selectOne("BookMapper.getBookById", book);
	}

	@Override
	public int getTotal(Criteria cri) {
		return mybatis.selectOne("BookMapper.getTotal", cri);
	}

	@Override
	public void update(BookVO book) throws Exception {
		mybatis.update("BookMapper.updateBook", book);
	}

	@Override
	public List<BCateVO> getCateList() {
		return mybatis.selectList("BookMapper.getCateList");
	}

	@Override
	public List<BookVO> getLikeBookList(Criteria cri) {
		return mybatis.selectList("BookMapper.getLikeBookList", cri);
	}
	
}
