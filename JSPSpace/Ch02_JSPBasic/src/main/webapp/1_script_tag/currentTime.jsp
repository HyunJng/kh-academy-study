<%@ page import="java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	Calendar cal = Calendar.getInstance();
	int hour = cal.get(Calendar.HOUR_OF_DAY);
	int minute = cal.get(Calendar.MINUTE);
	int second = cal.get(Calendar.SECOND);	
%>
<title>Insert title here</title>
</head>
<body>
	<!-- expression : html문서 출력 용으로 사용 -->
	<p>jsp:: 현재 시간은 <%=hour %>시 <%=minute %>분 <%=second %>초 입니다.</p>
</body>
</html>