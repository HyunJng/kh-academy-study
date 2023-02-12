package com.dadok.domain;

public class BookVO {
	private String bookId;
	private String title;
	private String image;
	private String author;
	private String publisher;
	private String contents;
	private int fullPrice;
	
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getFullPrice() {
		return fullPrice;
	}

	public void setFullPrice(int fullPrice) {
		this.fullPrice = fullPrice;
	}

	@Override
	public String toString() {
		return "BookVO [bookId=" + bookId + ", title=" + title + ", image=" + image + ", author=" + author
				+ ", publisher=" + publisher + ", contents=" + contents + ", fullPrice=" + fullPrice + "]";
	}
}
