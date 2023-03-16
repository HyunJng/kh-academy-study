package com.carrot.domain;

import java.sql.Date;

public class ReplyVO {

	private int replyId;
	private String bookId;
	private int memberId;
	private String content;
	private int rating;
	private Date regDate;
	
	// 편의를 위해 추가
	private String memberEmail;
	private String memberName;
	private String bookName;
	
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		content = content.trim();
		this.content = content;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	@Override
	public String toString() {
		return "ReplyVO [replyId=" + replyId + ", bookId=" + bookId + ", memberId=" + memberId + ", content=" + content
				+ ", rating=" + rating + ", regDate=" + regDate + ", memberEmail=" + memberEmail + ", memberName="
				+ memberName + ", bookName=" + bookName + "]";
	}
}
