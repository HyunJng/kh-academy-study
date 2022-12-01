package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdditionalInfoServlet")
public class AdditionalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Request 정보 출력</title></head>");
		out.print("<body><h3>추가적인 요청 정보</h3>");
		out.print("Request method: " + req.getMethod() + "<br/>"); 
		// /*을 썼을 떄 정보
		out.print("Path Info: " + req.getPathInfo() + "<br/>"); 
		out.print("Path Translated: " + req.getPathTranslated() + "<br/>"); 
		// 쿼리와 body정보
		out.print("Query String: " + req.getQueryString() + "<br/>"); 
		out.print("Content Length: " + req.getContentLength() + "<br/>"); 
		out.print("Content Type: " + req.getContentType() + "<br/>"); 
		out.print("</body></html>");
		out.close();
	}
}
