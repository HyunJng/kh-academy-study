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
	session.setAttribute("notebook", "노트북");
	%>
	
	<h3>노트북을 장바구니에 담았습니다.</h3>
	<a href="car.jsp">자동차 매장 가기</a>
</body>
</html>