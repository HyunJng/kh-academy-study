package com.carrot.repository;

import java.util.List;

import com.carrot.domain.AdvertVO;
import com.carrot.domain.AttachImageVO;
import com.carrot.domain.Criteria;

public interface AdvertRepository {
	// 광고 등록(advertId 반환)
	void saveAdvert(AdvertVO advert);
	// 광고 이미지 등록
	void saveAdvertImage(AttachImageVO image);
	// 광고 목록 가져오기
	List<AdvertVO> getAdvertList(Criteria cri); 
	// 전체 광고 개수
	int getTotal();
}
