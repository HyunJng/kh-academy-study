<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>web.xml에서 init parameter값 가져오기(application.getInitParameter)</h3>
	<p>이름: ${initParam.myName }</p>
	<p>주소 : ${initParam.myAddr}</p>
</body>
</html>