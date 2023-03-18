package com.carrot.repository;

import java.util.List;

import com.carrot.domain.Criteria;
import com.carrot.domain.MemberVO;

public interface MemberRepository {

	// 회원 저장
	public void save(MemberVO member);
	
	// 회원 email로 검색
	public int emailCheck(MemberVO member);
	
	// 회원찾기(Email)
	public MemberVO findMemberbyEmail(MemberVO member);
	
	// 회원찾기(Id)
	public MemberVO findMemberbyId(MemberVO member);
	
	// 회원 목록 검색
	public List<MemberVO> getMemberList(Criteria cri);
	
	// 회원 전체 수 검색
	public int getTotal(Criteria cri);
	
	// BAN회원 정보 변경
	public void updateBan(MemberVO member);
	
	// 회원 탈퇴
	public int deleteMember(int memberId);
	
}
