package practice_cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CartViewSession")
public class CarViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		HttpSession session = req.getSession(false);
		session.setMaxInactiveInterval(60 * 60); // 1시간
		Enumeration<String> sessionName = session.getAttributeNames();
		PrintWriter out = resp.getWriter();
		
		out.print("<html><head></head><body>");
		out.print("<h3>장바구니 리스트</h3>");
		if(session !=null) {
			while(sessionName.hasMoreElements()) {
				out.print(session.getAttribute(sessionName.nextElement()) + "<br/>");
			}
		}else {
		}
		String contextPath = req.getContextPath() + "/4_practice_cart/productAdd.html";
		out.print("<a href=" + contextPath + ">상품선택 페이지</a><br/>");
		out.print("<a href='CartDeleteSession'>장바구니 비우기</a><br/>");
		out.print("</body></html>");
	}
	
}
