package com.carrot.repository;

import java.util.List;

import com.carrot.domain.BookVO;
import com.carrot.domain.Criteria;

public interface BookRepository {

	// 책 저장
	public void save(BookVO book) throws Exception;
	
	// 책 id로 검색
	public BookVO getBookById(BookVO book);
	
	// 책 리스트 가져오기
	public List<BookVO> getBookList(Criteria cri);
	
	// 전체 게시글 개수 구하기
	public int getTotal();
	
	// 책 정보 수정
	public void update(BookVO book) throws Exception;
	
	// 책 정보 삭제
	public void delete(BookVO book);
}
