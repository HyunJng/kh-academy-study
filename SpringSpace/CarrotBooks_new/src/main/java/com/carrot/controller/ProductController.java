package com.carrot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carrot.domain.BookVO;
import com.carrot.service.BookService;

@Controller
@RequestMapping("/product")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	private BookService bookService;
	
	@Autowired
	public ProductController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/detail/{bookId}")
	public String productDetailGet(@PathVariable("bookId")String bookId, Model model) {
		logger.info("bookDetail 페이지 진입");
		BookVO book = new BookVO();
		book.setBookId(bookId);

		model.addAttribute("book", bookService.findBookById(book));
		return "/bookDetail";
	}
}
