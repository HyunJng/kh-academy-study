<%@page import="dto.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>primary key로 조회한 Book 정보 결과</h3>
	<%
	Book book = (Book)request.getAttribute("book");
	if(book == null){
	%>
		<p>조회하는 도서가 없습니다.</p>
	<%
	} else {
	%>	
		<p>ID : <%= book.getId() %></p>
		<p>TITLE : <%= book.getTitle() %></p>
		<p>PUBLISHER : <%=book.getPublisher() %></p>
		<p>PRICE : <%=book.getPrice() %></p>
	<%
	}
	%>		
	
</body>
</html>