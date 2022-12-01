<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>오라클 데이터베이스 연결 테스트</h3>
<% 
	//1. driver class를 load
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//2. database 연결
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "madang", "madang");
%>
	<p>madang 데이터베이스 연결 성공</p>
<%
	con.close();
%>
</body>
</html>