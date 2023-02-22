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
	
	public BookVO findBookById(BookVO book) {
		return bookRepository.getBookById(book);
	}
	
	public List<BookVO> getBookList(Criteria cri) {
		return bookRepository.getBookList(cri);
	}
	
	public PageMaker getBookPageMaker(Criteria cri) {
		int total = bookRepository.getTotal(cri);
		return new PageMaker(cri, total);
	}
	
	public List<BCateVO> getCateList(){
		return bookRepository.getCateList();
	}
}
