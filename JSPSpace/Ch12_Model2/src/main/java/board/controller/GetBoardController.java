package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardVO;
import board.model.impl.BoardDAO;
import user.model.UserVO;
import user.model.impl.UserDAO;

@WebServlet("/getBoard.do")
public class GetBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBoardController() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		response.sendRedirect("getBoard.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
