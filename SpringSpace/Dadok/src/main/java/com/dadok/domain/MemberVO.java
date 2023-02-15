package com.dadok.domain;

import java.sql.Date;

public class MemberVO {
	private int memberNum;
	private String memberEmail;
	private String memberPw;
	private String memberName;
	private String memberAddr1;
	private String memberAddr2;
	private String memberAddr3;
	private String memberCk;
	private int memberPoint;
	private Date regDate;
	private M_LoginType loginType;
	
	public MemberVO() { }

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberAddr1() {
		return memberAddr1;
	}

	public void setMemberAddr1(String memberAddr1) {
		this.memberAddr1 = memberAddr1;
	}

	public String getMemberAddr2() {
		return memberAddr2;
	}

	public void setMemberAddr2(String memberAddr2) {
		this.memberAddr2 = memberAddr2;
	}

	public String getMemberAddr3() {
		return memberAddr3;
	}

	public void setMemberAddr3(String memberAddr3) {
		this.memberAddr3 = memberAddr3;
	}

	public String getMemberCk() {
		return memberCk;
	}

	public void setMemberCk(String memberCk) {
		this.memberCk = memberCk;
	}

	public int getMemberPoint() {
		return memberPoint;
	}

	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public M_LoginType getLoginType() {
		return loginType;
	}

	public void setLoginType(M_LoginType loginType) {
		this.loginType = loginType;
	}

	@Override
	public String toString() {
		return "MemberVO [memberNum=" + memberNum + ", memberEmail=" + memberEmail + ", memberPw=" + memberPw
				+ ", memberName=" + memberName + ", memberAddr1=" + memberAddr1 + ", memberAddr2=" + memberAddr2
				+ ", memberAddr3=" + memberAddr3 + ", memberCk=" + memberCk + ", memberPoint=" + memberPoint
				+ ", regDate=" + regDate + ", loginType=" + loginType + "]";
	}
}
