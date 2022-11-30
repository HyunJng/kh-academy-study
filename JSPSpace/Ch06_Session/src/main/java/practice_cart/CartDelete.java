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


@WebServlet("/CartDelete")
public class CartDelete extends HttpServlet {
   private static final long serialVersionUID = 1L;
     
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html; charset=utf-8");
   
      PrintWriter out = response.getWriter();
      out.print("<html><head></head><body>");

      out.print("<h3>장 바구니를 비웁니다.</h3>");
      
      HttpSession session = request.getSession(false);
      if (session != null) {
         session.invalidate();
      } else {
         out.print("<p>세션 없음</p>");
      }
      
      String contextPath = request.getContextPath() + "/4_practice_cart/productAdd.html";
      out.print("<a href=" + contextPath + "> 상품선택 페이지 </a>");
      out.print("</body></html>");
   }

   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}