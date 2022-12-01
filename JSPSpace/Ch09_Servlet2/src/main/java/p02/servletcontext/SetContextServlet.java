package p02.servletcontext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetContext")
public class SetContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SetContextServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ServletContext application = this.getServletContext();
		response.setContentType("text/html; charset=utf-8");
		
		application.setAttribute("name", "홍길동");
		application.setAttribute("age", "20");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("name과 age 키를 application 기본객체에 성공적으로 저장하였습니다.");
		out.print("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
