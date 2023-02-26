package com.carrot.domain;

public class CartVO {
	/* cart테이블 */
	private int cartId;
	private int memberId;
	private String bookId;
	private int bookCount;
	
	/* book 관련 */
	private String title;
	private String bookImage;
	private int fullPrice;
	private int discountPer;
	
	/* 편리를 위해 추가 */
	private int salePrice;
	private int totalPrice;
	private int point;
	private int totalPoint;
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBookImage() {
		return bookImage;
	}
	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
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
	
	public int getPoint() {
		return point;
	}
	
	public int getTotalPoint() {
		return totalPoint;
	}
	
	public void initSaleTotal() {
		this.salePrice = (int)(this.fullPrice * (1 - (this.discountPer / 100.0)));
		this.totalPrice = (int)(this.salePrice * this.bookCount);
		this.point = (int)(Math.floor(this.salePrice * 0.05));
		this.totalPoint = this.point * this.bookCount;
	}
	
	@Override
	public String toString() {
		return "CartVO [cartId=" + cartId + ", memberId=" + memberId + ", bookId=" + bookId + ", bookCount=" + bookCount
				+ ", title=" + title + ", fullPrice=" + fullPrice + ", discountPer=" + discountPer
				+ ", salePrice=" + salePrice + ", totalPrice=" + totalPrice + ", point=" + point + ", totalPoint="
				+ totalPoint + "]";
	}
}
