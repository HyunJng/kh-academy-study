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

public class UpdateBoardController implements Controller{
       
    public UpdateBoardController() {
        
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		request.setCharacterEncoding("utf-8");
    	System.out.println("글 수정 처리");
    	
    	// 사용자 입력 정보 추출
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String seq = request.getParameter("seq");

		// DB 연동
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.updateBoard(vo);
		
		// 3. 화면 navigation
		return "getBoardList.do";
    }
}
