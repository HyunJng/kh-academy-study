package signup.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.UserVO;
import user.model.impl.UserDAO;

@WebServlet("/deleteSign.do")
public class DeleteSignController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteSignController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 입력 정보 추출
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("authUser");

		// 2. DB 연동
		UserDAO userDAO = new UserDAO();
		userDAO.deleteUser(user);
		
		// 화면 navigation (back to getBoardList.jsp)
		session.invalidate();
		response.sendRedirect("login.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
