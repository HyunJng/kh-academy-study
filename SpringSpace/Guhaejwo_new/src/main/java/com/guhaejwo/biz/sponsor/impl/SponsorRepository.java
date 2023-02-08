package com.guhaejwo.biz.sponsor.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guhaejwo.biz.sponsor.SponsorDTO;
import com.guhaejwo.biz.sponsor.SponsorItemDTO;

@Repository
public class SponsorRepository {

	@Autowired
	private SqlSessionTemplate mybatis;
	
//	public SponsorDAO(SqlSessionTemplate mybatis) {
//		this.mybatis = mybatis;
//	}
	
	// 후원 내역 insert
	public void insertSponsor(SponsorDTO sponsorDTO) {
		System.out.println("---> SponsorRepository.insertSponsor() 실행");
		mybatis.insert("SponsorDAO.insertSponsor", sponsorDTO);
	}
	
	public SponsorItemDTO getSponsorItem(SponsorItemDTO sponsorItemDTO) {
		System.out.println("---> SponsorRepository.getSponsorItem() 실행");
		return (SponsorItemDTO) mybatis.selectOne("SponsorDAO.getSponsorItem", sponsorItemDTO);
		
	}
	
}
