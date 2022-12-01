<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>config 기본 객체를 이용한 web.xml에 등록된 초기 parameter값 읽어 오기</title>
</head>
<body>
	<h1>config 기본 객체를 이용한 web.xml에 등록된 초기 parameter값 읽어 오기</h1>
	<%
	/* config 기본 객체 사용법
	1. web.xml에 등록
	2. web.xml에 jsp파일(servlet)별로 설정 정보 등록 가능
	3. web.xml에 servlet로 설정된 정보를 읽어올 때 사용
	*/
	String dirPath= config.getInitParameter("dirPath");
	String username= config.getInitParameter("username");
	%>
	<p>dirPath : <%=dirPath%></p>
	<p>username : <%=username%></p>
</body>
</html>