package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.UserVO;
import user.model.impl.UserDAO;

@WebServlet("/loginout.do")
public class LoginoutController extends HttpServlet {

	public LoginoutController() {
	}

	// logout
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("login.html");
	}
	
	// login
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("userid");
		String password = request.getParameter("password");
		
		// argument용
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		// login한 user
		UserVO user = UserDAO.getUser(vo);

		HttpSession session = request.getSession();

		if (user != null) {
			session.setAttribute("authUser", user);
			response.sendRedirect("membersOnly.jsp");
		} else {
			response.sendRedirect("login.html");
		}
	}

}
