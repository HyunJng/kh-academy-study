package com.dadok.repository;

import java.util.List;

import com.dadok.domain.BookVO;
import com.dadok.domain.Criteria;

public interface BookRepository {

	// 책 저장
	public void save(BookVO book) throws Exception;
	
	// 책 리스트 가져오기
	public List<BookVO> getBookList(Criteria cri);
	
	// 전체 게시글 개수 구하기
	public int getTotal();
}
