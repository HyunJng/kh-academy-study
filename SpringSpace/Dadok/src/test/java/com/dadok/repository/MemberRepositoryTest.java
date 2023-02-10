package com.dadok.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dadok.domain.M_LoginType;
import com.dadok.domain.MemberVO;


@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberRepositoryTest {

	@Autowired MemberRepository memberRepository;
	
	/*
	@Test
	public void 회원가입() {
		MemberVO member = new MemberVO();
		
		member.setMemberEmail("uuu@naver.com");
		member.setMemberPw("1234");
		member.setMemberName("유길동");
		member.setMemberAddr1("test");
		member.setMemberAddr2("test");
		member.setMemberAddr3("test");
		member.setMemberCk("USER");
		member.setLoginType(M_LoginType.GENERAL);
		
		memberRepository.save(member);
	}
	
	@Test
	public void 이메일중복체크() {
		MemberVO member = new MemberVO();
		member.setMemberEmail("test");
		int exist = memberRepository.emailCheck(member);

		assertThat(exist, is(equalTo(1)));
	}
	 * */
	@Test
	public void 회원이메일검색() {
		MemberVO member = new MemberVO();
		member.setMemberEmail("test");
		member.setMemberPw("test");
		
		MemberVO loginMember = memberRepository.findMemberbyEmail(member);
		
		System.out.println(loginMember);
		assertThat(loginMember.getMemberEmail(), is(member.getMemberEmail()));
		assertThat(loginMember.getMemberPw(), is(member.getMemberPw()));
	}
	/*
	@Test
	public void 회원검색실패() {
		MemberVO member = new MemberVO();
		member.setMemberEmail("test");
		member.setMemberPw("aaa");
		
		MemberVO loginMember = memberRepository.login(member);

		assertThat(loginMember, nullValue());
	}
	 */
	
}