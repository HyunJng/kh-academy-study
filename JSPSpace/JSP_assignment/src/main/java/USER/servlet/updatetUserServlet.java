package USER.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import USER.UserDAO;
import USER.UserVO;

/**
 * Servlet implementation class updatetUserServlet
 */
@WebServlet("/updatetUser.do")
public class updatetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatetUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("ID");
		String password = request.getParameter("pwd1");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String adr = request.getParameter("adr");
		System.out.println(id);
		System.out.println(adr);
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		vo.setTel(tel);
		vo.setEmail(email);
		vo.setAdr(adr);
		
		UserDAO dao = new UserDAO();
		dao.updateUser(vo);
		dao.getUserInfo(vo);
		HttpSession session = request.getSession();
		
		response.sendRedirect("getUserInfo.do?id="+id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
