package com.dadok.domain;

import java.sql.Date;

public class BookVO {
	private String bookId;
	private String title;
	private String bookImage;
	private String author;
	private String publisher;
	private String bookIntro;
	private String bookCate;
	private int fullPrice;
	private int bookStock;
	private int discountPer;
	private Date regDate;
	private Date updateDate;
	
	public BookVO() { }

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getBookIntro() {
		return bookIntro;
	}

	public void setBookIntro(String bookIntro) {
		this.bookIntro = bookIntro;
	}

	public String getBookCate() {
		return bookCate;
	}

	public void setBookCate(String bookCate) {
		this.bookCate = bookCate;
	}

	public int getFullPrice() {
		return fullPrice;
	}

	public void setFullPrice(int fullPrice) {
		this.fullPrice = fullPrice;
	}

	public int getBookStock() {
		return bookStock;
	}

	public void setBookStock(int bookStock) {
		this.bookStock = bookStock;
	}

	public int getDiscountPer() {
		return discountPer;
	}

	public void setDiscountPer(int discountPer) {
		this.discountPer = discountPer;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "BookVO [bookId=" + bookId + ", title=" + title + ", bookImage=" + bookImage + ", author=" + author
				+ ", publisher=" + publisher + ", bookIntro=" + bookIntro + ", bookCate=" + bookCate + ", fullPrice="
				+ fullPrice + ", bookStock=" + bookStock + ", discountPer=" + discountPer + ", regDate=" + regDate
				+ ", updateDate=" + updateDate + "]";
	}

}

