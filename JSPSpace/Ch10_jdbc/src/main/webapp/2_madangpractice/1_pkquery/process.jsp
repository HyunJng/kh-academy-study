<%@page import="dto.Book"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	//1. driver class load
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//2. database연결
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "madang", "madang");
	//3. sql문을 처리할 수 있는 Statement객체 생성
	Statement stmt = con.createStatement();
	//4. form tag를 가진 jsp에서 넘긴 parameter의 code값 가져오기
	String code = request.getParameter("code");
	//5. sql문 만들기 
	String sql = "select * from book where bookid = '" + code + "'";
	//6. sql문 실행하고 결과값 가져오기
	ResultSet rs = stmt.executeQuery(sql);
	
	Book book = null;
	
	if(rs.next()){// select결과가 있을 때만 작동
		book = new Book();
		
		book.setId(rs.getString("bookid"));
		book.setTitle(rs.getString("bookname"));
		book.setPublisher(rs.getString("publisher"));
		book.setPrice(rs.getInt("price"));
		
	}
	rs.close();
	stmt.close();
	con.close();
	//7. request 기본 객체에 book 인스턴스 저장(data가 없을 떄는 null 저장)
	request.setAttribute("book", book);
	
	//8. 결과를 web화면에 출력할 jsp로 forwarding
	RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
	dispatcher.forward(request, response);
%>
</body>
</html>