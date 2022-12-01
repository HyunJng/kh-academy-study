package practice_cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CartSaveSession")
public class CartSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String[] arr = req.getParameterValues("car");
		HttpSession session = req.getSession();

		if(arr != null) {
			for(int i = 0; i<arr.length; i++) {
				session.setAttribute(arr[i], arr[i]);
			}
		}
		PrintWriter out = resp.getWriter();
		out.print("<html><head></head><body>");
		out.print("Product 추가: <a href='CartViewSession'>장바구니 보기</a>");
		out.print("</body></html>");
	}
	
}
