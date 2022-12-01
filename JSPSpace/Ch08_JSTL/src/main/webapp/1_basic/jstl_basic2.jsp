<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="login" value="hong" scope="session"/>
	<c:set var="pass" value="1234" />
	
	<h3>변수 선언과 출력 결과</h3>
	<p>Session: <%= session.getAttribute("login") %></p>
	<p>login : <c:out value="${login}" /></p>
	<p>pass : <c:out value="${pass}" /></p>
	
	<!-- session.removeAttribute("logn") -->
	<c:remove var="login" scope="session"/>
	<h3>loign 삭제 후 출력 결과</h3>
	<p>login : <c:out value="${login}" /></p>
	<p>pass : <c:out value="${pass}" /></p>
	
	<h3>error처리 try-catch</h3>
	<p>10/0 결과 = <c:catch var="errmsg"><%=10/0 %></c:catch></p>
	<p> <c:out value="${errmsg }"/></p>
	
</body>
</html>