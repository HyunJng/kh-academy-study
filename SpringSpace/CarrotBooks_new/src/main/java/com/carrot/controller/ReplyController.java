package com.carrot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.carrot.domain.Criteria;
import com.carrot.domain.ReplyPageVO;
import com.carrot.domain.ReplyVO;
import com.carrot.service.ReplyService;

//@RestController
@Controller
@RequestMapping("/reply")
public class ReplyController {

	@Autowired ReplyService replyService;
	Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	// 댓글 등록
	@PostMapping("/enroll")
	public String enrollReplyPost(ReplyVO reply) {
		logger.info("enrolReplyPost 진입");
		replyService.enrollReply(reply);
		return "redirect: /product/detail/" + reply.getBookId();
	}
	
	// 댓글 페이징
	@GetMapping(value ="/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ReplyPageVO getReplyListPost(Criteria cri) {
		logger.info("getReplyListPost 진입");
		
		return replyService.getReplyList(cri);
	}
}
