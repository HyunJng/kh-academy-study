<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>

<%
	Timestamp now = new Timestamp(System.currentTimeMillis());
	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
	String str = f.format(now);
%>
<p>오늘은 <%=str %>입니다.</p>
</body>
</html>