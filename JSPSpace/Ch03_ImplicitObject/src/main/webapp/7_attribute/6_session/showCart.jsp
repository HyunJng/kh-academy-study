<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 내용 보기</title>
</head>
<body>
	<h3>장바구니 내용</h3>
	<%
	Enumeration<String> items = session.getAttributeNames();
	
	while(items.hasMoreElements()){
		String name = items.nextElement(); 
		String value = session.getAttribute(name) + "";
	%>
		<h4>구매 물품: <%=value %></h4>
	<%	
	}
	%>
</body>
</html>