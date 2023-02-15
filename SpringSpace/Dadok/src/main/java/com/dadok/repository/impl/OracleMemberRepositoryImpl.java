package com.dadok.repository.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dadok.domain.Criteria;
import com.dadok.domain.MemberVO;
import com.dadok.repository.MemberRepository;

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
	public List<MemberVO> getMemberList(Criteria cri) {
		return mybatis.selectList("MemberMapper.getMemberList", cri);
	}

	@Override
	public int getTotal() {
		return mybatis.selectOne("MemberMapper.getTotal");
	}
	
}
