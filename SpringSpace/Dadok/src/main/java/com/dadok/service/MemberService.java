package com.dadok.service;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dadok.domain.MemberVO;
import com.dadok.repository.MemberRepository;

@Service("memberService")
public class MemberService {

	private MemberRepository memberRepository;
	private JavaMailSender mailSender; 
	private BCryptPasswordEncoder pwEncoder;
	
	@Autowired
	public MemberService(MemberRepository memberRepository, JavaMailSender mailSender, BCryptPasswordEncoder pwEncoder) {
		this.memberRepository = memberRepository;
		this.mailSender = mailSender;
		this.pwEncoder = pwEncoder;
	}
	
	// 로그인
	public MemberVO login(MemberVO member) {
		MemberVO tempMember = memberRepository.findMemberbyEmail(member);
		
		if(tempMember != null) {
			String rawPw = member.getMemberPw();
			String findPw = tempMember.getMemberPw();
			if(pwEncoder.matches(rawPw, findPw)) {
				return tempMember; 
			}else return null;
		}else {
			return null;
		}
	}
	
	// 회원가입
	public void join(MemberVO member) {
		passwordEncode(member);
		memberRepository.save(member);
	}
	
	// 비밀번호 인코드
	public void passwordEncode(MemberVO member) {
		String rawPassword = member.getMemberPw();
		String encodePassword = pwEncoder.encode(rawPassword); 
		member.setMemberPw(encodePassword);
	}
	
	// 회원 중복 검사
	public int countMemberbyEmail(MemberVO member) {
		int exist = memberRepository.emailCheck(member);
		
		if(exist != 0) {
			return 1;	// 중복 아이디 존재 O
		} else
			return 0; // 중복 아이디 존재 X
	}
	
	// 인증 이메일 전송
	public int sendEmailforAuth(MemberVO member) {
		Random random = new Random();
		int checkNum = random.nextInt(8889) + 1111; // 1111 ~ 9999
		
        String subject = "Dadok 회원가입 인증 메일";
        String from = "khjung1654@naver.com";
        String to = member.getMemberEmail();
        String content = "아래 인증번호를 입력하시오" + "<br><br>"
        					+ "인증번호는 " + checkNum + " 입니다.";
		/*        
        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail,true,"UTF-8");
            
            mailHelper.setFrom(from);
            mailHelper.setTo(to);
            mailHelper.setSubject(subject);
            mailHelper.setText(content, true);
            
            mailSender.send(mail);

        } catch(Exception e) {
            e.printStackTrace();
        }

		 * */
        return checkNum;
	}	
	
}
