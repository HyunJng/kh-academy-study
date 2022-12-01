package p01.servletconfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( name="/InitParamAnnoServlet",
			urlPatterns= {"/initParamAnno"},
			initParams= { @WebInitParam (name="dirPath", value="d:\\test"),
						  @WebInitParam (name="userid", value="system")
			}
)
public class InitParamAnnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InitParamAnnoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
