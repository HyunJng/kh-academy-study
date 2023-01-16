package com.spring.view.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import com.spring.view.controller.Controller;

public class GetBoardController implements Controller{
       
    public GetBoardController() {
        
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("글 상세 조회");
    	
    	// 1. 검색할 게시글 번호(primary key) 추출
		String seq = request.getParameter("seq");

		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);

		// 3. 검색 결과를 session에 저장하고 getBoard.jsp 화면으로 이동
		HttpSession session = request.getSession();
		session.setAttribute("board", board);

		return "getBoard";
    }
}
