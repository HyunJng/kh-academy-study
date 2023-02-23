package com.carrot.domain;

public class CartVO {
	/* cart테이블 */
	private int cartId;
	private int memberId;
	private String bookId;
	private int bookCount;
	
	/* book 관련 */
	private String bookName;
	private int fullPrice;
	private int discountPer;
	
	/* 편리를 위해 추가 */
	private int salePrice;
	private int totalPrice;
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public int getBookCount() {
		return bookCount;
	}
	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getFullPrice() {
		return fullPrice;
	}
	public void setFullPrice(int fullPrice) {
		this.fullPrice = fullPrice;
	}
	public int getDiscountPer() {
		return discountPer;
	}
	public void setDiscountPer(int discountPer) {
		this.discountPer = discountPer;
	}
	
	public int getSalePrice() {
		return salePrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}
	
	@Override
	public String toString() {
		return "CartVO [cartId=" + cartId + ", memberId=" + memberId + ", bookId=" + bookId + ", bookCount=" + bookCount
				+ ", bookName=" + bookName + ", fullPrice=" + fullPrice + ", discountPer=" + discountPer
				+ ", salePrice=" + salePrice + ", totalPrice=" + totalPrice + "]";
	}

}
