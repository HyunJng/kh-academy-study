package p05.servlet.urlpattern2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// *.do : 확장자 pattern => 모든 pass이름이 .do 끝나는 곳에 이 servlet이 적용
@WebServlet("*.do")
public class ETestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ETestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("ETestServlet");
		out.print("</body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
