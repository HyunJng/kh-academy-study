package com.carrot.domain;

import java.sql.Date;
import java.util.List;

public class AdvertVO {
	private int advertId;
	private String AdvertName;
	private Date regDate;
	private Date endDate;
	private int uploader;
	private String company;
	private String bookId;
	private List<AttachImageVO> imageList;
	
	public int getAdvertId() {
		return advertId;
	}
	public void setAdvertId(int advertId) {
		this.advertId = advertId;
	}
	public String getAdvertName() {
		return AdvertName;
	}
	public void setAdvertName(String advertName) {
		AdvertName = advertName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getUploader() {
		return uploader;
	}
	public void setUploader(int uploader) {
		this.uploader = uploader;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public List<AttachImageVO> getImageList() {
		return imageList;
	}
	public void setImageList(List<AttachImageVO> imageList) {
		this.imageList = imageList;
	}

	@Override
	public String toString() {
		return "AdvertVO [advertId=" + advertId + ", AdvertName=" + AdvertName + ", regDate=" + regDate + ", endDate="
				+ endDate + ", uploader=" + uploader + ", company=" + company + ", bookId=" + bookId + ", imageList="
				+ imageList + "]";
	}
}
