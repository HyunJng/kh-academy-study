package com.spring.view.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller{
       
    public GetBoardListController() {
        
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("글 목록 검색 처리");
//    	request.setCharacterEncoding("utf-8");


		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList");
		return mav;
    }
}
