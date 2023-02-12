package com.dadok.repository;

import com.dadok.domain.BookVO;

public interface BookRepository {

	// 책 저장
	public void save(BookVO book);
}
