package com.carrot.repository.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carrot.domain.Criteria;
import com.carrot.domain.MemberVO;
import com.carrot.repository.MemberRepository;

@Repository("memberRepository")
public class OracleMemberRepositoryImpl implements MemberRepository{

	private final SqlSessionTemplate mybatis;
	
	@Autowired
	public OracleMemberRepositoryImpl(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}
	
	@Override
	public void save(MemberVO member) {
		mybatis.insert("MemberMapper.insertMember", member);
	}

	@Override
	public int emailCheck(MemberVO member) {
		return mybatis.selectOne("MemberMapper.countMemberByEmail", member);
	}

	@Override
	public MemberVO findMemberbyEmail(MemberVO member) {
		return mybatis.selectOne("MemberMapper.getMemberByEmail", member);
	}

	@Override
	public MemberVO findMemberbyId(MemberVO member) {
		return mybatis.selectOne("MemberMapper.getMemberById", member);
	}

	@Override
	public List<MemberVO> getMemberList(Criteria cri) {
		return mybatis.selectList("MemberMapper.getMemberList", cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return mybatis.selectOne("MemberMapper.getTotal", cri);
	}

	@Override
	public void updateBan(MemberVO member) {
		mybatis.update("MemberMapper.updateBAN", member);
	}
	
}
