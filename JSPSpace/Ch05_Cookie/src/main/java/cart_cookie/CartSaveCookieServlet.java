package cart_cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CartSaveCookie")
public class CartSaveCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String car = req.getParameter("car");
		Cookie c = new Cookie("car", car);
		resp.addCookie(c);
		
		PrintWriter out = resp.getWriter();
		out.print("<html><head></head><body>");
		out.print("Product 추가: <a href='CartViewCookie'>장바구니 보기</a>");
		out.print("</body></html>");
		
	}
	
}
