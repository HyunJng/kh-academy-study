package practice_cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CartDeleteSession")
public class CartDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		HttpSession session = req.getSession(false);
		PrintWriter out = resp.getWriter();
		out.print("<html><head></head><body>");
		out.print("<h3>장바구니 비우기</h3>");
		if(session != null) {
			session.invalidate();
		}else {
			out.print("<p>세션 없음</p>");
		}
		
		String contextPath = req.getContextPath() + "/4_practice_cart/productAdd.html";
		out.print("<a href=" + contextPath + ">상품선택 페이지</a><br/>");
		out.print("</body></html>");
	}
}
