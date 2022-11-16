<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% // jsp script라는 뜻. 여러개 가능
// java coding
Date date = new Date();
SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
String today = sf.format(date);
%>
<p>오늘 날짜는 <%= today %>입니다.</p>
</body>
</html>