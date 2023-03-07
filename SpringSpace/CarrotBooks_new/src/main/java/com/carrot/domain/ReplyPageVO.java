package com.carrot.domain;

import java.util.List;

public class ReplyPageVO {

	private List<ReplyVO> replyList;
	private PageMaker pageInfo;
	public List<ReplyVO> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<ReplyVO> replyList) {
		this.replyList = replyList;
	}
	public PageMaker getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageMaker pageInfo) {
		this.pageInfo = pageInfo;
	}

	@Override
	public String toString() {
		return "ReplyPageVO [replyList=" + replyList + ", pageInfo=" + pageInfo + "]";
	}
	
}
