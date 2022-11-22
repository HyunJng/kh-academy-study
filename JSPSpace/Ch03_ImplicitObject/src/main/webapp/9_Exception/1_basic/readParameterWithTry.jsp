<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parameter 출력</title>
</head>
<body>
	<p>name parameter 값: </p>
	
	<%
	try{
	%>
		<%= request.getParameter("name").toString() %>
	<%
	}catch(Exception e){
	%>
		<p style="color:red">name parameter값이 올바르지 않습니다.</p>
	<%
	}
	%>		
</body>
</html>