package com.carrot.domain;

public class OrderPageItemVO {

	private String bookId;
	private int bookCount;
	
	private int bookPrice;
	private int discountPer;
	private String bookName;
	private String bookImage;
	
	/* 편의를 위한 변수 */
	private int salePrice;
	private int totalPrice;
	private int point;
	private int totalPoint;
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
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
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
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getTotalPoint() {
		return totalPoint;
	}
	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}
	public String getBookImage() {
		return bookImage;
	}
	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	
	public void initSaleTotal() {
		this.salePrice =(int) (this.bookPrice * (1 - (this.discountPer / 100.0)));
		this.point = (int)(Math.floor(this.salePrice * 0.05));
		this.totalPrice = this.salePrice * this.bookCount;
		this.totalPoint = this.point * this.bookCount;
	}
	
	@Override
	public String toString() {
		return "OrderItemVO [bookId=" + bookId + ", bookCount=" + bookCount + ", bookPrice=" + bookPrice
				+ ", discountPer=" + discountPer + ", bookName=" + bookName + ", bookImage=" + bookImage
				+ ", salePrice=" + salePrice + ", totalPrice=" + totalPrice + ", point=" + point + ", totalPoint="
				+ totalPoint + "]";
	}
}
