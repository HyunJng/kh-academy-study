package com.carrot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carrot.domain.AdvertVO;
import com.carrot.domain.AttachImageVO;
import com.carrot.domain.BookVO;
import com.carrot.domain.Criteria;
import com.carrot.domain.MemberVO;
import com.carrot.domain.PageMaker;
import com.carrot.repository.AdvertRepository;
import com.carrot.repository.BookRepository;
import com.carrot.repository.MemberRepository;

@Service
public class AdminService {

	private BookRepository bookRepository;
	private MemberRepository memberRepository;
	private AdvertRepository advertRepository;
	
	@Autowired
	public AdminService(BookRepository bookRepository, MemberRepository memberRepository, AdvertRepository advertRepository) {
		this.bookRepository = bookRepository;
		this.memberRepository = memberRepository;
		this.advertRepository = advertRepository;
	}
	
	/// 책 관련
	public void saveBook(BookVO book) throws Exception{
		bookRepository.save(book);
	}
	
	public void updateBook(BookVO book) throws Exception{
		bookRepository.update(book);
	}
	
	public void deleteBook(BookVO book) {
		bookRepository.delete(book);
	}
	
	// 멤버 관련
	public List<MemberVO> getMemberList(Criteria cri) {
		return memberRepository.getMemberList(cri);
	}
	
	public PageMaker getMemberPageMaker(Criteria cri) {
		int total = memberRepository.getTotal(cri);
		return new PageMaker(cri, total);
	}
	
	public void changeMemberBan(MemberVO member) {
		memberRepository.updateBan(member);
	}
	
	
	// 광고 관련
	@Transactional
	public void saveAdvert(AdvertVO advert) {
		advertRepository.saveAdvert(advert);
		for(AttachImageVO image : advert.getImageList()) {
			image.setAdvertId(advert.getAdvertId());
			advertRepository.saveAdvertImage(image);
		}
	}
}
