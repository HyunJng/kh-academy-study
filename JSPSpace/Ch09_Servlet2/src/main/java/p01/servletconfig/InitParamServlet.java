package p01.servletconfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/InitParam")
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InitParamServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// getInitParameter => ServletConfig의 method
		// ServletConfig는 servlet마다 web.xml이나 annotation으로 설정된 값들을 가져올 때 사용
		String dirPath = getInitParameter("dirPath");
		String userId = getInitParameter("userid");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("디렉토리 경로 : " + dirPath + "<br>");
		out.print("아이디 값 : " + userId + "<br>");
		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
