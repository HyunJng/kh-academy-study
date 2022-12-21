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

@WebServlet("/modifyUser.do")
public class ModifyUserController extends HttpServlet {

	public ModifyUserController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String id = request.getParameter("userid");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String level = request.getParameter("level");

		UserVO vo = new UserVO(name, id, password, email, tel, level);
		
		// DB 고치기
		UserDAO.updateUserInfo(vo);
		
		// session고치기
		HttpSession session = request.getSession();
		session.setAttribute("authUser", vo);
		
		response.sendRedirect("membersOnly.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
