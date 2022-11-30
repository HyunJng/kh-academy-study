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
Cookie c = new Cookie("onehour", "H");
c.setMaxAge(60*60);   // 1시간 = 60분 * 60초
response.addCookie(c);
%>

<p>쿠키 유효시간을 1시간으로 설정</p>
</body>
</html>