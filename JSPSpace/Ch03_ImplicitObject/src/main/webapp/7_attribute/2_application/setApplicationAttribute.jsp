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
	String name = request.getParameter("name");
	String value = request.getParameter("value");
	
	if(name != null && value != null){
		application.setAttribute(name, value);
	}
	%>
	<%
	if(name != null && value != null){
	%>
		<p>application 기본 객체 attribute 설정 정보 : <%=name %> : <%=value %></p>
	<%
	}else {
	%>
		<p>application 기본 객체의 attribute 설정 안함</p>
	<%
	}
	%>
</body>
</html>