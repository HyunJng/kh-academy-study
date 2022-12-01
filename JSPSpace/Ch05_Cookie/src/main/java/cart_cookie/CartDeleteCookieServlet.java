package cart_cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CartDeleteCookie")
public class CartDeleteCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		Cookie[] cookies = req.getCookies();
		PrintWriter out = resp.getWriter();

		out.print("<html><head></head><body>");
		out.print("<h3>장바구니 리스트</h3>");
		if(cookies !=null && cookies.length > 0) {
			for(Cookie c : cookies) {
				//Cookie c1 = new Cookie(c.getName(), "");
				c.setMaxAge(0);
				resp.addCookie(c);
			}
		}
		
		String contextPath = req.getContextPath() + "/5_cart/productAdd.html";
		out.print("<a href=" + contextPath + ">상품선택 페이지</a><br/>");
		out.print("</body></html>");
	}
}
