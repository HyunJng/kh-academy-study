package practice_animal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Animal")
public class AnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String animal = req.getParameter("ANIMAL");
		HttpSession session = req.getSession();
		
		session.setAttribute("ANIMAL", animal);
		
		PrintWriter out = resp.getWriter();
		out.print("세션에 저장 완료");
//		String path = req.getContextPath() + "/Result";
		out.print("<html><head></head><body>");
		out.print("<h3>좋아하는 음식은?</h3>");
		out.print("<form action='Result' method='get'>");
		out.print("<input type='text' name='FOOD'>");
		out.print("<input type='submit' value='확인'>");
		out.print("</form>");
		out.print("</body></html>");
	}
}
