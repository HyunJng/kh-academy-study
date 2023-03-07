package com.carrot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrot.domain.Criteria;
import com.carrot.domain.PageMaker;
import com.carrot.domain.ReplyPageVO;
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
	
	// 댓글 페이징
	public ReplyPageVO getReplyList(Criteria cri) {
		ReplyPageVO vo = new ReplyPageVO();
		
		vo.setReplyList(replyRepository.getReplyList(cri));
		vo.setPageInfo(new PageMaker(cri, replyRepository.getReplyTotal(cri.getBookId())));
		return vo;
	}
}
