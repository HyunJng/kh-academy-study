package com.carrot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carrot.domain.BookVO;
import com.carrot.domain.MemberVO;
import com.carrot.domain.ReplyVO;
import com.carrot.service.BookService;
import com.carrot.service.ReplyService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/product")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	private BookService bookService;
	private ReplyService replyService;
	private ObjectMapper objm = new ObjectMapper();
	
	@Autowired
	public ProductController(BookService bookService, ReplyService replyService) {
		this.bookService = bookService;
		this.replyService = replyService;
	}
	
	@GetMapping("/detail/{bookId}")
	public String productDetailGet(@PathVariable("bookId")String bookId, Model model, HttpServletRequest req) {
		logger.info("bookDetail 페이지 진입");
		// 책  세팅
		BookVO book = new BookVO();
		book.setBookId(bookId);
		model.addAttribute("book", bookService.findBookById(book));

		// 댓글 세팅
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		ReplyVO reply = null;
		try {
			if(member != null) {
				reply = replyService.getReply(bookId, member.getMemberId());
			}
			if(reply != null) {
				model.addAttribute("member_reply", objm.writeValueAsString(reply));
			} else { 
				model.addAttribute("member_reply_check", "false");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("member_reply_check", "false");
		}
		
		return "/bookDetail";
	}
}
