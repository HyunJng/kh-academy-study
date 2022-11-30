package p02.servletcontext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetContext")
public class GetContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetContextServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ServletContext application = this.getServletContext();
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("이름 : " + application.getAttribute("name") + "<br>");
		out.print("나이 : " + application.getAttribute("age") + "<br>");
		out.print("</body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
