<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exception 처리</title>
</head>
<body>
	<p>요청 처리 과정 중에서 에러가 발생하였습니다.</p>
	<p>빠른 시간 내에 문제를 해결하도록 하겠습니다.</p>
	<p>에러 타입 : <%= exception.getClass().getName() %></p>
	<p>에러 메세지 : <%=exception.getMessage() %></p>
	
</body>
</html>