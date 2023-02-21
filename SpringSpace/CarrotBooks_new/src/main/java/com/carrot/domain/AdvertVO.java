package com.carrot.domain;

import java.sql.Date;
import java.util.List;

public class AdvertVO {
	private int advertId;
	private String advertName;
	private Date regDate;
	private Date endDate;
	private MemberVO uploaderInfo;
	private int uploader;
	private String uploaderName;
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
		return advertName;
	}
	public void setAdvertName(String advertName) {
		this.advertName = advertName;
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
	public MemberVO getUploaderInfo() {
		return uploaderInfo;
	}
	public void setUploaderInfo(MemberVO uploaderInfo) {
		this.uploaderInfo = uploaderInfo;
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
	public String getUploaderName() {
		return uploaderName;
	}
	public void setUploaderName(String uploaderName) {
		this.uploaderName = uploaderName;
	}
	@Override
	public String toString() {
		return "AdvertVO [advertId=" + advertId + ", advertName=" + advertName + ", regDate=" + regDate + ", endDate="
				+ endDate + ", uploaderInfo=" + uploaderInfo + ", uploader=" + uploader + ", uploaderName="
				+ uploaderName + ", company=" + company + ", bookId=" + bookId + ", imageList=" + imageList + "]";
	}
	
}
