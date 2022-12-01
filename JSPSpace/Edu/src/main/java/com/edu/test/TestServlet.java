package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/queryTest")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String[] hobby = req.getParameterValues("hobby");
		String gender = req.getParameter("gender");
		String intro = req.getParameter("introduction");
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Query 문자열 테스트</title></head>");
		out.print("<body><h1>GET 방식으로 요청되었습니다.</h1>");
		out.print("ID: " + id + "<br/>");
		out.print("Password: " + pw + "<br/>");
		out.print("name: " + name + "<br/>");
		out.print("hobby: ");
		for(int i = 0; i<hobby.length; i++)
			out.print(hobby[i] + " ");
		out.print("<br/>");
		out.print("gender: " + gender + "<br/>");
		out.print("introduction: " + intro + "<br/>");
		out.print("전체 질의 문자열: " + req.getQueryString());
		out.println("</body></html>");
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String[] hobby = req.getParameterValues("hobby");
		String gender = req.getParameter("gender");
		String intro = req.getParameter("introduction");
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Query 문자열 테스트</title></head>");
		out.print("<body><h1>POST 방식으로 요청되었습니다.</h1>");
		out.print("ID: " + id + "<br/>");
		out.print("Password: " + pw + "<br/>");
		out.print("name: " + name + "<br/>");
		out.print("hobby: ");
		for(int i = 0; i<hobby.length; i++)
			out.print(hobby[i] + " ");
		out.print("<br/>");
		out.print("gender: " + gender + "<br/>");
		out.print("introduction: " + intro + "<br/>");
		out.println("</body></html>");
		out.close();
	}
}
