package com.spring.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;


@Repository
public class BoardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;


	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("---> JDBC로 insertBoard() 기능 처리");
		
		mybatis.insert("BoardDAO.insertBoard", vo);
//		mybatis.commit();
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("---> JDBC로 updateBoard() 기능 처리");
		
		mybatis.update("BoardDAO.updateBoard", vo);
//		mybatis.commit();
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("---> JDBC로 deleteBoard() 기능 처리");

		mybatis.delete("BoardDAO.deleteBoard", vo);
//		mybatis.commit();
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("---> JDBC로 getBoard() 기능 처리");
		
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		
		System.out.println("---> JDBC로 getBoardList() 기능 처리");
		
//		if (vo.getSearchCondition().equals("TITLE")) {
//			return mybatis.selectList("BoardDAO.getBoardList_T", vo);
//		} else if (vo.getSearchCondition().equals("CONTENT")) {
//			return mybatis.selectList("BoardDAO.getBoardList_C", vo);
//		}
//		return null;
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}
	
}