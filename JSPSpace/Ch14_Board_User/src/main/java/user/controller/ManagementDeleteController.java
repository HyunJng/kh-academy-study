package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardVO;
import board.model.impl.BoardDAO;
import user.model.UserVO;
import user.model.impl.UserDAO;

@WebServlet("/manageDelete.do")
public class ManagementDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ManagementDeleteController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 입력 정보 추출
		String[] seq = request.getParameterValues("seqch");
		String[] id = request.getParameterValues("idch");
		
		// 2. DB 연동
		if(seq != null) {
			BoardVO vo = new BoardVO();
			for(String s : seq) {
				vo.setSeq(Integer.parseInt(s));
				BoardDAO boardDAO = new BoardDAO();
				boardDAO.deleteBoard(vo);
			}
		}
		
		if(id != null) {
			UserVO uvo = new UserVO();
			for(String u : id) {
				uvo.setId(u);
				UserDAO userDAO = new UserDAO();
				userDAO.deleteUser(uvo);
			}
		}
		
		
		// 화면 navigation (back to getBoardList.jsp)
		response.sendRedirect("management.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
