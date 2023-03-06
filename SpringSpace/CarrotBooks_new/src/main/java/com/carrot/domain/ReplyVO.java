package com.carrot.domain;

import java.sql.Date;

public class ReplyVO {

	private int replyId;
	private String bookId;
	private int memberId;
	private String content;
	private int rating;
	private Date regDate;
	
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
	@Override
	public String toString() {
		return "ReplyVO [replyId=" + replyId + ", bookId=" + bookId + ", memberId=" + memberId + ", content=" + content
				+ ", rating=" + rating + ", regDate=" + regDate + "]";
	}
}