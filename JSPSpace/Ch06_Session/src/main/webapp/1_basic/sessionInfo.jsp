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
	<%
	Date now = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	%>
	<p>세션 ID : <%=session.getId() %></p>
	<%
	now.setTime(session.getCreationTime());
	%>
	<p>세션 생성시간: <%= sf.format(now)%></p>
	<%
	now.setTime(session.getLastAccessedTime());
	%>
	<p>세션 최근 접근시간: <%= sf.format(now)%></p>
		
</body>
</html>