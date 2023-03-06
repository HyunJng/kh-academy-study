package com.carrot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrot.domain.ReplyVO;
import com.carrot.repository.ReplyRepository;

@Service
public class ReplyService {

	@Autowired
	private ReplyRepository replyRepository;
	
	// 댓글 등록
	public int enrollReply(ReplyVO reply) {
		return replyRepository.enrollReply(reply);
	}
	
	// 댓글 찾기
	public ReplyVO getReply(String bookId, int memberId) {
		ReplyVO vo = new ReplyVO();
		vo.setBookId(bookId);
		vo.setMemberId(memberId);
		
		return replyRepository.getReply(vo);
	}
}
