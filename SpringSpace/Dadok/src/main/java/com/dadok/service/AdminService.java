package com.dadok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dadok.domain.BookVO;
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
}
