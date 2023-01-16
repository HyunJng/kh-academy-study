package com.spring.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.SearchCriteria;


@Repository
public class BoardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;


	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
//		System.out.println("---> MyBatis로 insertBoard() 기능 처리");
		
		mybatis.insert("BoardDAO.insertBoard", vo);
//		mybatis.commit();
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
//		System.out.println("---> MyBatis로 updateBoard() 기능 처리");
		
		mybatis.update("BoardDAO.updateBoard", vo);
//		mybatis.commit();
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
//		System.out.println("---> MyBatis로 deleteBoard() 기능 처리");

		mybatis.delete("BoardDAO.deleteBoard", vo);
//		mybatis.commit();
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
//		System.out.println("---> MyBatis로 getBoard() 기능 처리");
		
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		
//		System.out.println("---> MyBatis로 getBoardList() 기능 처리");
		
//		if (vo.getSearchCondition().equals("TITLE")) {
//			return mybatis.selectList("BoardDAO.getBoardList_T", vo);
//		} else if (vo.getSearchCondition().equals("CONTENT")) {
//			return mybatis.selectList("BoardDAO.getBoardList_C", vo);
//		}
//		return null;
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}

	public int getTotalPages(SearchCriteria cri) {

		return mybatis.selectOne("BoardDAO.getTotalPages", cri);
	}

	// 글 목록 조회 with paging
	public List<BoardVO> getBoardListWithPaging(SearchCriteria cri) {
		
//		System.out.println("---> MyBatis로 getBoardListWithPaging() 기능 처리");
//		System.out.println("page : " + cri.getPageNum());
//		System.out.println("amount : " + cri.getAmount());
		
		return mybatis.selectList("BoardDAO.getBoardListWithPaging", cri);
	}
	
	// 글 목록 조회 with paging
	public List<BoardVO> getBoardListWithDynamicPaging(SearchCriteria cri) {
		
//		System.out.println("---> MyBatis로 getBoardListWithDynamicPaging() 기능 처리");
		
		return mybatis.selectList("BoardDAO.getBoardListWithDynamicPaging", cri);
	}
	
}