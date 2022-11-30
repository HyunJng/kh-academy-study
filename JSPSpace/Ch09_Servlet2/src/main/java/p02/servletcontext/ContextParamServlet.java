package p02.servletcontext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContextParam")
public class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContextParamServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ServletContext application = this.getServletContext();
		String driver = application.getInitParameter("driver");
		String savePath = application.getInitParameter("savePath");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("드라이버 명 : " + driver + "<br>");
		out.print("저장 경로 : " + savePath + "<br>");
		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
