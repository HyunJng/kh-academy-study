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
	String code = request.getParameter("code");
	String viewPageURI = "";
	
	switch(code){
	case "A": viewPageURI="/3_forward/practice/viewModule/a.jsp"; break;
	case "B": viewPageURI="/3_forward/practice/viewModule/b.jsp"; break;
	case "C": viewPageURI="/3_forward/practice/viewModule/c.jsp"; break;
	}
	%>
	<jsp:forward page="<%=viewPageURI%>" />
</body>
</html>