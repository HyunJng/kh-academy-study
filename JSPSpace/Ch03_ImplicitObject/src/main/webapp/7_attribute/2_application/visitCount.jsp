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
	int count = 0;
	if(application.getAttribute("clickno") != null){
		count = (Integer)application.getAttribute("clickno");
	}
	count++;
	application.setAttribute("clickno", count);
	%>
	<h1>현재까지 클릭한 횟수: <%= application.getAttribute("clickno") %></h1>
</body>
</html>