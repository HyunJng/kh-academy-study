package com.carrot.repository;

import com.carrot.domain.ReplyVO;

public interface ReplyRepository {
	// 댓글 등록
	int enrollReply(ReplyVO vo);
	
	// 댓글 존재 체크용(memberId, bookId)
	ReplyVO getReply(ReplyVO vo);
}
