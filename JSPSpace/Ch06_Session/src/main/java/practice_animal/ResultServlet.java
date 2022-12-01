package practice_animal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Result")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String food = req.getParameter("FOOD");
		HttpSession session = req.getSession();
		session.setAttribute("FOOD", food);

		String animal = (String)session.getAttribute("ANIMAL");
		
		PrintWriter out = resp.getWriter();
		out.print("세션에 저장 완료");
//		String path = req.getContextPath() + "/Result";
		out.print("<html><head></head><body>");
		out.print("<h3>당신이 좋아하는 것들</h3>");
		out.print("당신은 " + food +"와 " + animal + "을 좋아합니다."); 
		out.print("</body></html>");
	}
}
