package com.carrot.repository;

import java.util.List;

import com.carrot.domain.AttachImageVO;

public interface ImageRepository {

	// 이미지 데이터 반환
	public List<AttachImageVO> getAttachList(int refId);
}
