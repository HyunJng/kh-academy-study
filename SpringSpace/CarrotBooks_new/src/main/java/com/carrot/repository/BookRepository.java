package com.carrot.repository;

import java.util.List;

import com.carrot.domain.BCateVO;
import com.carrot.domain.BookVO;
import com.carrot.domain.Criteria;

public interface BookRepository {

	// 책 저장
	public void save(BookVO book) throws Exception;
	
	// 책 id로 검색
	public BookVO getBookById(BookVO book);
	
	// 책 리스트 가져오기(최신순)
	public List<BookVO> getBookList(Criteria cri);
	
	// 전체 게시글 개수 구하기
	public int getTotal(Criteria cri);
	
	// 책 정보 수정
	public void update(BookVO book) throws Exception;
	
	// 책 정보 삭제
	public void delete(BookVO book);
	
	// 카테고리 리스트 
	public List<BCateVO> getCateList();
	
	// 책 리스트 가져오기(별점순)
	public List<BookVO> getLikeBookList(Criteria cri);

}
