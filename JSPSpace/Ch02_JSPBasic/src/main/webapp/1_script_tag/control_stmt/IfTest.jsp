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
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String color = request.getParameter("color");
//	PrintWriter out =response.getWriter();
	//PrintWriter의 인스턴스인 out객체도 자동으로 만들어놓음
	out.println("<h1>좋아하는 색 선택</h1>");
	out.println(name + "님이 선택한 color은 " + color + "입니다.");
%>
</body>
</html>