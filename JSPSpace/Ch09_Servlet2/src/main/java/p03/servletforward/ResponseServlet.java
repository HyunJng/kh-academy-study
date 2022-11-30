package p03.servletforward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Response")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResponseServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = (String) request.getAttribute("username");
		String userAddr = (String) request.getAttribute("useraddress");
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("이름 : " + userName + "<br>");
		out.print("나이 : " + userAddr + "<br>");
		out.print("</body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
