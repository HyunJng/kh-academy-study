package com.carrot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrot.domain.ReplyVO;
import com.carrot.service.ReplyService;

//@RestController
@Controller
@RequestMapping("/reply")
public class ReplyController {

	@Autowired ReplyService replyService;
	Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@PostMapping("/enroll")
	public String enrollReplyPost(ReplyVO reply) {
		logger.info("enrolReplyPost 진입");
		System.out.println(reply);
		replyService.enrollReply(reply);
		return "redirect: /product/detail/" + reply.getBookId();
	}
	
}
