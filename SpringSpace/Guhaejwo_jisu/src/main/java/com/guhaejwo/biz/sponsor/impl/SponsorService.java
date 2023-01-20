package com.guhaejwo.biz.sponsor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guhaejwo.biz.sponsor.SponsorDTO;
import com.guhaejwo.biz.sponsor.SponsorItemDTO;

@Service("sponsorService")
public class SponsorService{

	private SponsorRepository sponsorRepository;
	
	@Autowired
	public SponsorService(SponsorRepository sponsorRepository) {
		this.sponsorRepository = sponsorRepository;
	}
	
	
	public void insertSponsor(SponsorDTO sponsorDTO) {
		sponsorRepository.insertSponsor(sponsorDTO);
	}

	public SponsorItemDTO getSponsorItem(SponsorItemDTO sponsorItemDTO) {
		return sponsorRepository.getSponsorItem(sponsorItemDTO);
	}

}
