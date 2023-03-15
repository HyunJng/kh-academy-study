package com.carrot.repository.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carrot.domain.Criteria;
import com.carrot.domain.ReplyVO;
import com.carrot.repository.ReplyRepository;

@Repository("replyRepository")
public class OracleReplyRepository implements ReplyRepository {

	@Autowired private SqlSessionTemplate mybatis;
	
	 @Override
	public int enrollReply(ReplyVO vo) {
		 return mybatis.insert("ReplyMapper.enrollReply", vo);
	}

	@Override
	public ReplyVO getReply(ReplyVO vo) {
		return mybatis.selectOne("ReplyMapper.getReply", vo);
	}

	@Override
	public List<ReplyVO> getReplyList(Criteria cri) {
		return mybatis.selectList("ReplyMapper.getReplyList", cri);
	}

	@Override
	public int getReplyTotal(String bookId) {
		return mybatis.selectOne("ReplyMapper.getReplyTotal", bookId);
	}

	@Override
	public int updateReply(ReplyVO vo) {
		return mybatis.update("ReplyMapper.updateReply", vo);
	}
	
}
