<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>세션 정보 조회</h3>
	<p>MEMBERID = <%= session.getAttribute("MEMBERID") %></p>
	<p>NAME = <%=session.getAttribute("NAME") %>
</body>
</html>