package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.UserVO;
import user.model.impl.UserDAO;

@WebServlet("/checkid.do")
public class CheckDuplIdController extends HttpServlet {
       
    public CheckDuplIdController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
//		System.out.println("userid: " + userid);
		PrintWriter out = response.getWriter();
		
		UserVO vo = new UserVO();
		vo.setId(userid);
		
		boolean isUser = false;
		
		if(UserDAO.existUserId(vo) != null){
			isUser = true;
		}
		System.out.println("isUser: " + isUser);
		
//		if(!isUser) {
//			System.out.println("id 중복 없음");
//		}else {
//			System.out.println("id 중복 있음");
//		}
		out.write(String.valueOf(isUser)); // ajax 결과 = isUser
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
