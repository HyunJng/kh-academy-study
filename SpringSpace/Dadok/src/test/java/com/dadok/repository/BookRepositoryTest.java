package com.dadok.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dadok.domain.BookVO;
import com.dadok.domain.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository bookRepository;

	/*
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
		
		try {
			bookRepository.save(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void 책리스트Get() {
		Criteria cri = new Criteria();
		List<BookVO> list = bookRepository.getBookList(cri);
		
		list.forEach(book -> System.out.println(book));
	}
	 * */
	@Test 
	public void 책개수() {
		int result = bookRepository.getTotal();
		System.out.println(result);
	}
}
