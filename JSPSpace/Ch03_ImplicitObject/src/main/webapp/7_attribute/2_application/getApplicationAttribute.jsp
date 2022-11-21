<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application 기본 객체 attribute 설정 정보 보기</title>
</head>
<body>
	<%
	Enumeration<String> attrs = application.getAttributeNames();
	
	while(attrs.hasMoreElements()) {
		String name = attrs.nextElement();
		Object value = application.getAttribute(name);
		
	%>
		<p>application 속성 : <b><%=name %> = <%=value %></b>
	<%
	}
	%>
</body>
</html>