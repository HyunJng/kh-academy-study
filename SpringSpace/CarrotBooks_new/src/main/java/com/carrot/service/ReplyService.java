package com.carrot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrot.domain.Criteria;
import com.carrot.domain.PageMaker;
import com.carrot.domain.ReplyPageVO;
import com.carrot.domain.ReplyVO;
import com.carrot.domain.UpdateReplyVO;
import com.carrot.repository.ReplyRepository;

@Service
public class ReplyService {

	@Autowired
	private ReplyRepository replyRepository;
	
	// 댓글 등록
	public int enrollReply(ReplyVO reply) {
		int result = replyRepository.enrollReply(reply); 
		setRating(reply.getBookId());
		
		return result;
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

	// 댓글 수정
	public int updateReply(ReplyVO vo) {
		int result = replyRepository.updateReply(vo);
		
		setRating(vo.getBookId());

		return result;
	}
	
	// 댓글 삭제
	public int deleteReply(ReplyVO vo) {
		int result = replyRepository.deleteReply(vo.getReplyId());
		
		setRating(vo.getBookId());
		
		return result;
	}
	
	// 평점 평균값 책에 setting
	public void setRating(String bookId) {
		double ratingAvg = replyRepository.getRatingAvarage(bookId);
		
		UpdateReplyVO urd = new UpdateReplyVO();
		urd.setBookId(bookId);
		urd.setRatingAvg(ratingAvg);
		
		replyRepository.updateRating(urd);
	}
}
