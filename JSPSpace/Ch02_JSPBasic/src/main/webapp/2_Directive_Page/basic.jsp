<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- scriptlet 요소 -->
<%
	String bookName = "JSP기초";
	String author = "최별균";
%>
<!-- experession 요소 -->
<b><%= bookName %></b>의 저자는 <%= author %>입니다.
</body>
</html>