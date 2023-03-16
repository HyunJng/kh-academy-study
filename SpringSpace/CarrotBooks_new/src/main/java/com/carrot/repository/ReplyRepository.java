package com.carrot.repository;

import java.util.List;

import com.carrot.domain.Criteria;
import com.carrot.domain.ReplyVO;
import com.carrot.domain.UpdateReplyVO;

public interface ReplyRepository {
	// 댓글 등록
	int enrollReply(ReplyVO vo);
	
	// 댓글 존재 체크용(memberId, bookId)
	ReplyVO getReply(ReplyVO vo);
	
	// 댓글 리스트(bookId)
	List<ReplyVO> getReplyList(Criteria cri);
	
	// 댓글 총 개수(bookId)
	int getReplyTotal(String bookId);
	
	// 댓글 리스트(keyword = memberId)
	List<ReplyVO> getReplyListbyMemberId(Criteria cri);
	
	// 댓글 총 개수(keyword = memberId)
	int getReplyTotalByMemberId(String keyword);
	
	// 댓글 수정
	int updateReply(ReplyVO vo);
	
	// 댓글 삭제
	int deleteReply(int replyId);
	
	// 평균 평점 구하기
	double getRatingAvarage(String bookId);
	
	// 평점 평균 반영하기
	int updateRating(UpdateReplyVO vo);
}
