<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
param.num1 : El 객체
: form tag등에서 parameter로 넘어오는 값을 관리하는 객체 
- (int num1 == Integer.parseInt(request.getParameter("num1")) )
 -->
<h3>덧셈결과</h3>
<p>add: ${param.num1 + param.num2 }</p>
</body>
</html>