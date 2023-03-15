package com.carrot.domain;

public class UpdateReplyVO {
	private String bookId;
	private double ratingAvg;

	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public double getRatingAvg() {
		return ratingAvg;
	}
	public void setRatingAvg(double ratingAvg) {
		this.ratingAvg = ratingAvg;
	}
	@Override
	public String toString() {
		return "UpdateReplyVO [bookId=" + bookId + ", ratingAvg=" + ratingAvg + "]";
	}
	
}
