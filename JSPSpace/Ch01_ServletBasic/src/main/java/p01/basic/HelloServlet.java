package p01.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// HelloServlet => tomcat server가 자식 class인 HttpServlet을 자동 형변환하고 instance생성하여
// doPost, doGet 메소드를 실행하면 polymorphism 방식에 의해서 자식인 HelloServlet에서 override한 메소드를 실행

// URL의 path부분을 setting하는 annotation임 (context root 다음의 path 지점)
// context root: 기본적으로 project이름임(Ch01_ServletBasic)
//@WebServlet("/HelloServlet")
@WebServlet("/hello/jsp")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// constructor
	public HelloServlet() {
		super();
	}

	// request 객체 : web browser에서 보내온 모든 정보를 갖고 있는 객체
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)	
			throws ServletException, IOException {
		// 1. web browser에서 전달한 정보 읽기(id, password 등 상황에 따라 다름)
		// 2. id, pwd를 이용해서 DBMS를 연결해서 해당 table에서 있는지를 check
		// 3. web browser에게 response결과값을 html형식으로 전송
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		out.println("<html><head></head><body><h1>서블릿 작성 예제입니다.</h1></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
