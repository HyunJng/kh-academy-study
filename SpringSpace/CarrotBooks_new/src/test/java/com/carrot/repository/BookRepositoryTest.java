package com.carrot.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.carrot.domain.BCateVO;
import com.carrot.domain.BookVO;
import com.carrot.domain.Criteria;
import com.carrot.repository.BookRepository;

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
	@Test 
	public void 책개수() {
		int result = bookRepository.getTotal();
		System.out.println(result);
	}
	@Test
	public void 책검색byId() {
		BookVO book = new BookVO();
		book.setBookId("1168340772 9791168340770");
		BookVO result = bookRepository.getBookById(book);
		System.out.println(result);
	}
	
	@Test
	public void 책수정() {
		BookVO book1 = new BookVO();
		book1.setBookId("1168340772 9791168340770");
		BookVO book2 = bookRepository.getBookById(book1);
		System.out.println("책id검색 결과: " + book2.getBookStock() + " " + book2.getUpdateDate());
		System.out.println(book2);
		// 수량 변경
		book2.setBookStock(3);
		
		try {
			// update
			bookRepository.update(book2);
			BookVO book3 = bookRepository.getBookById(book1);
			System.out.println("수정 결과: " + book3.getBookStock() + " " + book3.getUpdateDate());
		} catch(Exception e) {
			System.out.println("에러발생");
		}
	}
	 * */
	@Test
	public void 카테고리리스트() {
		List<BCateVO> list = bookRepository.getCateList();

		list.forEach(cate -> System.out.println(cate));
	}
}
