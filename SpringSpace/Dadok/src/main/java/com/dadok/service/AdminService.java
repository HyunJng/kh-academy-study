package com.dadok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dadok.domain.BookVO;
import com.dadok.domain.Criteria;
import com.dadok.domain.PageMaker;
import com.dadok.repository.BookRepository;

@Service
public class AdminService {

	private BookRepository bookRepository;
	
	@Autowired
	public AdminService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public void saveBook(BookVO book) throws Exception{
		bookRepository.save(book);
	}
	
	public BookVO findBookById(BookVO book) {
		return bookRepository.getBookById(book);
	}
	
	public List<BookVO> getBookList(Criteria cri) {
		return bookRepository.getBookList(cri);
	}
	
	public PageMaker getPageMaker(Criteria cri) {
		int total = bookRepository.getTotal();
		PageMaker pageMaker = new PageMaker(cri, total);
		return pageMaker;
	}
	
	public void updateBook(BookVO book) throws Exception{
		bookRepository.update(book);
	}
	
	public void deleteBook(BookVO book) {
		bookRepository.delete(book);
	}
}
