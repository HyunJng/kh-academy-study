package com.spring.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		// 1. Spring Container를 구동한다.
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring Container로부터 BoardServiceImpl 객체를 Lookup 한다.
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		// 3. 글 등록 테스트
		BoardVO vo = new BoardVO();
		vo.setSeq(150);
		vo.setTitle("Spring Transaction 제목");
		vo.setWriter("김길동");
		vo.setContent("Spring Transaction 내용");
		boardService.insertBoard(vo);
		
		// 4. 글 목록 검색 기능 테스트
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("--->" + board.toString());
		}
		
		// 5. Spring Container 졸료
		container.close();
	}

}
