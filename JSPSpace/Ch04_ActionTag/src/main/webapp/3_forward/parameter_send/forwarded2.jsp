<%@page import="java.util.Calendar"%>
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
/* 	1. <jsp:param> aciton tag로 전달 가능한 data type은 string만 가능함
	2. 만약 string data type의외의 데이터를 전송할 경우에는 setAttribute 사용을 권장
 */
	request.setCharacterEncoding("utf-8");
	%>	 
	 <%
	 Calendar cal = Calendar.getInstance();
	 request.setAttribute("time", cal);
	 %>
	<jsp:forward page="forwarded_result.jsp">
		<jsp:param value="홍길동" name="name"/>
	</jsp:forward>
</body>
</html>