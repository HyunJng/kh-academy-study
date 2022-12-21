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

@WebServlet("/insertSign.do")
public class InsertSignController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertSignController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 입력 정보 추출
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		if (email == null) { email = ""; }
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		if (tel == null) { tel = ""; }
		String role = request.getParameter("role");

		// 2. DB 연동
		UserVO vo = new UserVO();
		vo.setName(name);
		vo.setId(id);
		vo.setPassword(password);
		vo.setEmail(email);
		vo.setTel(tel);
		vo.setRole(role);
		
		UserDAO userDAO = new UserDAO();
		userDAO.insertSignup(vo);
		
		// 화면 navigation (back to getBoardList.jsp)
		response.sendRedirect("login.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
