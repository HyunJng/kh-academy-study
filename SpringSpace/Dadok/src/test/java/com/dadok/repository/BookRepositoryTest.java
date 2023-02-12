package com.dadok.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dadok.domain.BookVO;

@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void 책저장() {
		BookVO book = new BookVO();
		book.setBookId("111");
		book.setTitle("TEST");
		book.setBookImage("test");
		book.setAuthor("홍길동");
		book.setPublisher("고덕");
		book.setBookIntro("가나다");
		book.setBookCate("NOVEL");
		book.setFullPrice(1000);
		book.setBookStock(1);
		book.setDiscountPer(10);
		
		bookRepository.save(book);
	}
}
