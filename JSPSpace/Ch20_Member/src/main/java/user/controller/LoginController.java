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

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
    public LoginController() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// argument용
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		// login한 user
		UserVO user = UserDAO.getUser(vo);
		
		HttpSession session = request.getSession();
		
		
		if(user != null) {
			session.setAttribute("authUser", user);
			response.sendRedirect("userPage.jsp");
		} else {
			response.sendRedirect("login.html");
		}
	}

}
