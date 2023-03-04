package com.carrot.domain;

public class OrderItemVO {

	private int orderItemId;
	private String orderId;
	private String bookId;
	private int bookCount;
	private int bookPrice;
	private int discountPer;
	private int savePoint;
	
	/* 편의를 위한 변수 */
	private int salePrice;
	private int totalPrice;
	private int totalSavePoint;
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	public int getSavePoint() {
		return savePoint;
	}
	public void setSavePoint(int savePoint) {
		this.savePoint = savePoint;
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
	public int getTotalSavePoint() {
		return totalSavePoint;
	}
	public void setTotalSavePoint(int totalSavePoint) {
		this.totalSavePoint = totalSavePoint;
	}
	
	public void initSaleTotal() {
		this.salePrice = (int) (this.bookPrice * (1-this.discountPer/100.0));
		this.totalPrice = this.salePrice*this.bookCount;
		this.savePoint = (int)(Math.floor(this.salePrice*0.05));
		this.totalSavePoint =this.savePoint * this.bookCount;
	}
	
	@Override
	public String toString() {
		return "OrderItemVO [orderItemId=" + orderItemId + ", orderId=" + orderId + ", bookId=" + bookId
				+ ", bookCount=" + bookCount + ", bookPrice=" + bookPrice + ", discountPer=" + discountPer
				+ ", savePoint=" + savePoint + ", salePrice=" + salePrice + ", totalPrice=" + totalPrice
				+ ", totalSavePoint=" + totalSavePoint + "]";
	}
	
}
