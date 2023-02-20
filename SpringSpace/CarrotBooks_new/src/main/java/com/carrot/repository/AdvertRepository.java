package com.carrot.repository;

import com.carrot.domain.AdvertVO;
import com.carrot.domain.AttachImageVO;

public interface AdvertRepository {
	// 광고 등록(advertId 반환)
	void saveAdvert(AdvertVO advert);
	// 광고 이미지 등록
	void saveAdvertImage(AttachImageVO image);
}
