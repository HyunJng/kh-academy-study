package com.carrot.domain;

public class MemberInfoVO {
	private MemberVO member;
	private ReplyPageVO reply;
	
	public MemberVO getMember() {
		return member;
	}
	public void setMember(MemberVO member) {
		this.member = member;
	}

	public ReplyPageVO getReply() {
		return reply;
	}
	public void setReply(ReplyPageVO reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		return "MemberInfoVO [member=" + member + ", reply=" + reply + "]";
	}

}
