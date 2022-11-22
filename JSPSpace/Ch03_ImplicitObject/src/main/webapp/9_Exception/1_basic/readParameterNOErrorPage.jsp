<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parameter 출력</title>
</head>
<body>
	<!-- 에러 발생 -->
	<p>name parameter값: <%= request.getParameter("name").toString() %></p>
</body>
</html>