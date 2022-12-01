package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/URLInfoServlet")
public class URLInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Request 정보 출력</title></head>");
		out.print("<body><h3>요청 방식과 프로토콜 정보</h3>");
		out.print("Request URI: " + req.getRequestURI() + "<br/>"); 
		out.print("Request URL: " + req.getRequestURL() + "<br/>"); 
		out.print("Context Path: " + req.getContextPath() + "<br/>"); //웹 애플리케이션 경로(이름) 
		out.print("Request Protocol: " + req.getProtocol() + "<br/>");
		out.print("ServletPath: " + req.getServletPath() + "<br/>"); //웹 애플리케이션을 루트로 한 서블릿 경로
		out.print("</body></html>");
		out.close();
	}
}
