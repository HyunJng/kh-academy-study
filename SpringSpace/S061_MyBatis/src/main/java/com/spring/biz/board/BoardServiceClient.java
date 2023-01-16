package com.spring.biz.board;

import java.util.List;

import com.spring.biz.board.impl.BoardDAO;

public class BoardServiceClient {

	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		
		BoardVO vo = new BoardVO();
		vo.setTitle("myBatis 제목3");
		vo.setWriter("정길동");
		vo.setContent("myBatis 2번째 내용입니다.");
		//boardDAO.insertBoard(vo);
		
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("3");
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		System.out.println("boardList is Null? " + boardList.isEmpty());
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}

}
