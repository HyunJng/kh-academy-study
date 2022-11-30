<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>core If문 사용</h3>
	<p><c:if test="${10<20 }">20은 10보다 크다 </c:if></p>
	<p><c:if test="6+3 == 9" >6+3 == 9 </c:if></p>
	<p><c:if test="${param.name == 'hong'}">name의 parameter값이 ${param.name }입니다.</c:if></p>
	<p><c:if test="${param.age > 18 }" > 당신의 나이는 18세 이상입니다.</c:if></p>
</body>
</html>