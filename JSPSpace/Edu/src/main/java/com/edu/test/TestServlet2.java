package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/queryTest2")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Query 문자열 테스트</title></head>");
		out.print("<body><h1>POST 방식으로 요청되었습니다.</h1>");
		
		ServletInputStream input = req.getInputStream(); // request body와 Servlet 사이에 stream연결
		int len = req.getContentLength(); // body 문자열 길이
		byte[] buf = new byte[len];
		input.readLine(buf, 0, len); // input 입력 스트림을 줄 단위로 데이터 읽기
		String s = new String(buf); //바이트 배열을 String타입으로 새로 생성
		out.print("전체문자열: " + s);
		
		out.println("</body></html>");
		out.close();
	}
}
