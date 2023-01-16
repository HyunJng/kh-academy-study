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
	String first = request.getParameter("first");
	String second = request.getParameter("second");
	int result = Integer.parseInt(first) * Integer.parseInt(second);
	
	out.println("<h1>입력된 임의의 숫자 2개 곱하기</h1>");
	out.println("곱하기 결과: " + result);
%>
</body>
</html>