package practice_cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CartSave")
public class CartSave extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html; charset=utf-8");

      String car = request.getParameter("car");
      HttpSession session = request.getSession();
   // 처음부터 list로 넣어서 괜찮
      ArrayList<String> list = (ArrayList<String>) session.getAttribute("product");

      if (list == null) {
    	 list = new ArrayList<String>();
         list.add(car);
         session.setAttribute("product", list); // session에는 list주소가 저장되는 것.
      } else {
         list.add(car); // 이미 한번 setAttribute되어서 할 필요 없음. reference라 본체임.
      }

      PrintWriter out = response.getWriter();
      out.print("<html><head></head><body>");
      out.print("Product 추가 : <a href='CartView'>장바구니 보기</a>");
      out.print("</body></html>");
   }

}