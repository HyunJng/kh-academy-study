package p02.html_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. request객체에서 web browser에서 전송한 정보 읽기
		// getParameter method : 1개의 value를 가져올 때 사용
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		
		// 3. response 정보 설정
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		// check : userid=jsp, passwd=1234 일 경우 성공
		if(userid.equals("jsp") && passwd.equals("1234")) {
			out.println("<h3>로그인 성공</h3>");
		}
		else {
			out.println("<h3>로그인 실패</h3>");			
		}
		out.println("아이디 : " + userid + "<br>");
		out.println("비밀번호 : " + passwd+ "<br>");
		out.println("</body></html>");			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
