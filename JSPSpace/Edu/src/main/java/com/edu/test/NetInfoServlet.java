package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

@WebServlet("/NetInfoServlet")
public class NetInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>정보 출력 Servlet</title></head>");
		out.print("<body><h3>서버와 클라이언트 네트워크 관련 요청 정보</h3>");
		// request임 (server -> client)
		out.print("Request Scheme: " + req.getScheme() + "<br/>"); // HTTP 프로토콜
		out.print("Server Name: " + req.getServerName()+ "<br/>");	//서버 호스트 이름, 없으면 IP
		out.print("Server Address: " + req.getLocalAddr() + "<br/>");//서버의 IP
		out.print("Server Port: " + req.getServerPort() + "<br/>"); // 서버의 포트번호
		out.print("Client Address: " + req.getRemoteAddr() + "<br/>"); // 클라이언트 주소
		out.print("Client Host: " + req.getRemoteHost() + "<br/>"); // 클라이언트 호스트 이
		out.print("Client Port: " + req.getRemotePort() + "<br/>"); // 클라이언트 포트 번호
		out.print("</body></html>");
		out.close();
	}
}
