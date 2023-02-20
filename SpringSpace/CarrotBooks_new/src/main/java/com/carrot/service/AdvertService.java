package com.carrot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrot.domain.AdvertVO;
import com.carrot.domain.Criteria;
import com.carrot.domain.PageMaker;
import com.carrot.repository.AdvertRepository;

@Service
public class AdvertService {
	
	AdvertRepository advertRepository;
	
	@Autowired
	public AdvertService(AdvertRepository advertRepository) {
		this.advertRepository = advertRepository;
	}
	
	// 광고 목록 가져오기
	public List<AdvertVO> getAdvertList(Criteria cri) {
		return advertRepository.getAdvertList(cri);
	}
	// 페이지 생성
	public PageMaker getAdvertPageMaker(Criteria cri) {
		int total = advertRepository.getTotal();
		return new PageMaker(cri, total);
	}
}
