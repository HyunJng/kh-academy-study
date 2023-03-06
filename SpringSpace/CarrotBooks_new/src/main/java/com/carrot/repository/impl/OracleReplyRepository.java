package com.carrot.repository.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
}
