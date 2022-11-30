package p04.servletredirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RedirectRequest")
public class RedirectRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RedirectRequestServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("username", "홍길동");
		session.setAttribute("useraddress", "서울강남구");
		
		response.sendRedirect("RedirectResponse");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
