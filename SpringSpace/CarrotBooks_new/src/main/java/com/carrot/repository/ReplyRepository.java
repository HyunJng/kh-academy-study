package com.carrot.repository;

import java.util.List;

import com.carrot.domain.Criteria;
import com.carrot.domain.ReplyVO;

public interface ReplyRepository {
	// 댓글 등록
	int enrollReply(ReplyVO vo);
	
	// 댓글 존재 체크용(memberId, bookId)
	ReplyVO getReply(ReplyVO vo);
	
	// 댓글 페이징
	List<ReplyVO> getReplyList(Criteria cri);
	
	// 댓글 총 개수
	int getReplyTotal(String bookId);
}
