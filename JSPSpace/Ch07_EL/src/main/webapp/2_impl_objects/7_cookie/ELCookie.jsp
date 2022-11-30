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
	Cookie c = new Cookie("my", "admin");
	c.setMaxAge(60 * 60);
	response.addCookie(c);
%>
 
<h3>Cookie에서 EL 사용</h3>
<p>my 쿠키값 : ${cookie.my.value }</p>
<p>my 쿠키값 : ${cookie['my']['value'] }</p>
<p>my 쿠키유지시간 : ${cookie.my.maxAge}</p>
<p>my 쿠키이름: ${cookie.my}</p>
</body>
</html>