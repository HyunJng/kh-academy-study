package com.carrot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrot.domain.BCateVO;
import com.carrot.domain.BookVO;
import com.carrot.domain.Criteria;
import com.carrot.domain.PageMaker;
import com.carrot.repository.BookRepository;

@Service
public class BookService {
	private BookRepository bookRepository;
	
	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// 책 검색(책 id)
	public BookVO findBookById(BookVO book) {
		return bookRepository.getBookById(book);
	}
	
	// 책 목록 가져오기(최신순)
	public List<BookVO> getBookList(Criteria cri) {
		return bookRepository.getBookList(cri);
	}
	
	// 책 페이지 메이커 생성  
	public PageMaker getBookPageMaker(Criteria cri) {
		int total = bookRepository.getTotal(cri);
		return new PageMaker(cri, total);
	}
	
	// 책 카테고리 리스트 가져오기
	public List<BCateVO> getCateList(){
		return bookRepository.getCateList();
	}
	
	// 책 목록 가져오기(별점순)
	public List<BookVO> getLikeBookList(Criteria cri){
		return bookRepository.getLikeBookList(cri);
	}
}
