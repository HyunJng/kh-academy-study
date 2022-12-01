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

@WebServlet("/CartView")
public class CartView extends HttpServlet {
   private static final long serialVersionUID = 1L;


   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html; charset=utf-8");

      // getSession() : 기존의 session이 존재하면 session객체 전달, 없으면 session 객체를 새로 생성함을 의미함.
      // getSession(false) : 기존의 session이 존재하면 session객체 전달, 없으면 null 전달을 의미함.
      HttpSession session = request.getSession(false);
      session.setMaxInactiveInterval(60 * 60); // 1hour = 60min * 60sec

      PrintWriter out = response.getWriter();
      out.print("<html><head></head><body>");

      if (session != null) {
         ArrayList<String> list = (ArrayList<String>) session.getAttribute("product"); 
         out.print("<p>샘플 : " + list + "</p>");
      } else {
         out.print("<p>세션 없음</p>");
      }

      String contextPath = request.getContextPath() + "/4_practice_cart/productAdd.html";
      out.print("<a href=" + contextPath + "> 상품선택 페이지 </a>");
      out.print("<a href= 'CartDelete'> 상품선택 페이지 </a>");
      out.print("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doGet(request, response);
   }

}