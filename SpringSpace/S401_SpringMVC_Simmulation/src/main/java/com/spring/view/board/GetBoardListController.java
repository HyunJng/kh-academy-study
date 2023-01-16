package com.spring.view.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import com.spring.view.controller.Controller;

public class GetBoardListController implements Controller{
       
    public GetBoardListController() {
        
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("글 목록 검색 처리");
//    	request.setCharacterEncoding("utf-8");


		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		// 3. 검색 결과를 session에 저장하고 getBoardList.jsp로 이동
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);

		return "getBoardList";
    }
}
