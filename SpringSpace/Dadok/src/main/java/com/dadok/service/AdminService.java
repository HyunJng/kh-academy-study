package com.dadok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dadok.domain.BookVO;
import com.dadok.domain.Criteria;
import com.dadok.domain.MemberVO;
import com.dadok.domain.PageMaker;
import com.dadok.repository.BookRepository;
import com.dadok.repository.MemberRepository;

@Service
public class AdminService {

	private BookRepository bookRepository;
	private MemberRepository memberRepository;
	
	@Autowired
	public AdminService(BookRepository bookRepository, MemberRepository memberRepository) {
		this.bookRepository = bookRepository;
		this.memberRepository = memberRepository;
	}
	
	/// 책 관련
	public void saveBook(BookVO book) throws Exception{
		bookRepository.save(book);
	}
	
	public BookVO findBookById(BookVO book) {
		return bookRepository.getBookById(book);
	}
	
	public List<BookVO> getBookList(Criteria cri) {
		return bookRepository.getBookList(cri);
	}
	
	public PageMaker getBookPageMaker(Criteria cri) {
		int total = bookRepository.getTotal();
		return new PageMaker(cri, total);
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
		int total = memberRepository.getTotal();
		return new PageMaker(cri, total);
	}
	
	public void changeMemberBan(MemberVO member) {
		memberRepository.updateBan(member);
	}
	
	public MemberVO findMemberbyNum(MemberVO member) {
		return memberRepository.findMemberbyNum(member);
	}
}
