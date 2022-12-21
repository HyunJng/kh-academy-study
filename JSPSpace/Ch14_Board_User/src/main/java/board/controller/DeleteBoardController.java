package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardVO;
import board.model.impl.BoardDAO;
import user.model.UserVO;

@WebServlet("/deleteBoard.do")
public class DeleteBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteBoardController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 입력 정보 추출
		String seq = request.getParameter("seq");
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("authUser");
		
		// 2. DB 연동
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		
		if (user.getRole().equals("admin")) {
			boardDAO.deleteBoard(vo);
			response.sendRedirect("getBoardList.do");
		} else if (boardDAO.getBoard(vo).getWriter().equals(user.getName())) {
			boardDAO.deleteBoard(vo);
			response.sendRedirect("getBoardList.do");
		} else {
			alertAndBack(response, "게시글 삭제는 본인만 가능합니다.", "getBoardList.do");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public static void alertAndBack(HttpServletResponse response, String msg, String url) {
	    try {
	        response.setContentType("text/html; charset=utf-8");
	        PrintWriter w = response.getWriter();
	        w.write("<script>alert('"+msg+"');location.href='"+url+"';</script>");
	        w.flush();
	        w.close();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
}
