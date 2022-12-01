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
	session.setAttribute("MEMBERID", "madvirus");	
	session.setAttribute("NAME", "honggildong");	
	%>
	<p>세션에 정보 저장이 되었습니다.<p>
</body>
</html>