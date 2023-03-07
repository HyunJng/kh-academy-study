package com.carrot.domain;

import java.util.Arrays;
//현재 페이지 정보 클래스
public class Criteria {
	// 목록 관련
	private int pageNum;
	private int amount;
	// 검색관련
	private String type;
	private String[] typeArr;
	private String keyword;
	// 책관련
	private String cateCode;
	// 댓글관련
	private String bookId;
	
	public Criteria() {
		this.pageNum = 1;
		this.amount = 10;
	}
	
	public Criteria(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		typeArr = type.split("");
	}

	public String[] getTypeArr() {
		return typeArr;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCateCode() {
		return cateCode;
	}
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public void setCateCode(String cateCode) {
		if(typeArr == null) {
			typeArr = new String[] {"C"};
		} else { // 키워드가 있는 상태에서는 C 추가
			typeArr[typeArr.length] = "C";
		}
		this.cateCode = cateCode;
	}

	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", type=" + type + ", typeArr="
				+ Arrays.toString(typeArr) + ", keyword=" + keyword + ", cateCode=" + cateCode + ", bookId=" + bookId
				+ "]";
	}

}
