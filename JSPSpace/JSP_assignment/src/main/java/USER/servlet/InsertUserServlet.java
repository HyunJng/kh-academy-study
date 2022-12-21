package USER.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import USER.UserDAO;
import USER.UserVO;

/**
 * Servlet implementation class InsertUserServlet
 */
@WebServlet("/insertUser.do")
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setCharacterEncoding("utf-8");
		UserDAO userDAO = new UserDAO();
		UserVO vo = new UserVO();
		String id = request.getParameter("ID");
		String name = request.getParameter("name");
		String password = request.getParameter("pwd1");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String adr = request.getParameter("adr");
		String role = request.getParameter("role");
	
		vo.setId(id);
		vo.setName(name);
		vo.setPassword(password);
		vo.setTel(tel);
		vo.setEmail(email);
		vo.setAdr(adr);
		vo.setRole(role);
		userDAO.insertUser(vo);
		
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('회원가입이 완료되었습니다')");
		script.println("location.href='login.jsp'");
		script.println("</script>");
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
