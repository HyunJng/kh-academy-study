package com.guhaejwo.view.sponsor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.guhaejwo.biz.sponsor.SponsorDTO;
import com.guhaejwo.biz.sponsor.SponsorItemDTO;
import com.guhaejwo.biz.sponsor.impl.SponsorRepository;
import com.guhaejwo.biz.sponsor.impl.SponsorService;
import com.guhaejwo.biz.user.UserDTO;

@Controller
@RequestMapping("/sponsor")
public class SponsorController {

	private final SponsorService sponsorService;
	
	@Autowired
	public SponsorController(SponsorService sponsorService) {
		this.sponsorService = sponsorService;
	}
	
	// 후원 설명 이미지로 이동
	@GetMapping("/move")
	public String getSponsorPage() {
		return "/sponsor/sponsor_img";
	}
	
	// 후원 폼으로 이동
	@GetMapping(value="/get")
	public String getSponsorItem(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		SponsorItemDTO sponsorItem = new SponsorItemDTO();
		sponsorItem.setSponsorItemSeq(1);
		
		session.setAttribute("sponsor", sponsorService.getSponsorItem(sponsorItem));
		return "/sponsor/sponsor_form";
	}
	
	// 후원 내역 저장
	@PostMapping(value="/insert")
	public String insertSponsor(SponsorDTO sponsor) {
		sponsorService.insertSponsor(sponsor);
		
		return "/sponsor/sponsor_img";
	}
	
}
