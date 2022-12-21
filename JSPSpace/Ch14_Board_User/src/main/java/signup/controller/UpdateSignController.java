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

@WebServlet("/updateSign.do")
public class UpdateSignController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateSignController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 입력 정보 추출
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("authUser");
		
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String role = request.getParameter("role");
		
		// DB 연동
		UserVO vo = new UserVO();
		vo.setName(name);
		vo.setId(user.getId());
		vo.setPassword(password);
		vo.setEmail(email);
		if (vo.getEmail() == null) { vo.setEmail(""); }
		vo.setTel(tel);
		if (vo.getTel() == null) { vo.setTel(""); }
		vo.setRole(role);
		
		UserDAO userDAO = new UserDAO();
		userDAO.updateSignup(vo);
		
		// 화면 navigation
		response.sendRedirect("getBoardList.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
