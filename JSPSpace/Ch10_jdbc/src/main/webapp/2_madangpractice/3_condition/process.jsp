<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	//4. form tag를 가진 jsp에서 넘긴 parameter 값 가져오기
	String condition = request.getParameter("condition");
	String val = request.getParameter("val");
	//5. sql문 만들기 
	PreparedStatement pstmt = null;

	switch(condition){
	case "c": 
		pstmt = con.prepareStatement("select * from book where bookid = ?"); 
		pstmt.setInt(1, Integer.parseInt(val));
		break;
	case "t": 
		pstmt = con.prepareStatement("select * from book where bookname like '%'|| ? || '%'"); 
		pstmt.setString(1, val);
	break;
	case "p": 
		pstmt = con.prepareStatement("select * from book where publisher like '%'|| ? || '%'"); 
		pstmt.setString(1, val);
		break;
	case "pt": 
		pstmt = con.prepareStatement("select * from book where bookname like '%'|| ? || '%' or publisher like '%'|| ? || '%'"); 
		pstmt.setString(1, val);
		pstmt.setString(2, val);
		break;
	}

	//6. sql문 실행하고 결과값 가져오기
	ResultSet rs = pstmt.executeQuery();
	
	List<Map> list = new ArrayList<>();	// 동일한 이름의 책이 여러권 올 수 있어서 
	
	while(rs.next()){// select결과가 있을 때만 작동
		Map<String, Object> map = new HashMap<String, Object>();
	
		map.put("code", rs.getString("bookid"));
		map.put("title", rs.getString("bookname"));
		map.put("publisher", rs.getString("publisher"));
		map.put("price", rs.getInt("price"));

		list.add(map);
	}
	rs.close();
	stmt.close();
	con.close();
	//7. request 기본 객체에 book 인스턴스 저장(data가 없을 떄는 null 저장)
	request.setAttribute("list", list);
	
	//8. 결과를 web화면에 출력할 jsp로 forwarding
	RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
	dispatcher.forward(request, response);
%>
</body>
</html>