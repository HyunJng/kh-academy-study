package com.dadok.domain;

public class Criteria {
	private int pageNum;
	private int amount = 5;
	
	public Criteria() {
		this.pageNum = 1;
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

	public int getAmount() {
		return amount;
	}
}
