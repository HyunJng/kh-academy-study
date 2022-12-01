<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Success</title>
</head>
<body>
	<h3>Login 성공하셨습니다.</h3>
	
	<p>Login한 ID : <%= request.getAttribute("id") %></p>
	<p>Login한 PW: <%= request.getAttribute("password") %></p>
</body>
</html>