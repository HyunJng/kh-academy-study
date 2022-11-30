<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
	<h3>책 제목으로 조회한 결과 테이블</h3>
	<%
	List<Book> list = (ArrayList<Book>)request.getAttribute("list");
	if(list == null){
	%>
		<p>조회하는 도서가 없습니다.</p>
	<%
	} else {
	%>	
		<table border="1" align="center">
			<tr>
				<th>ID</th>
				<th>TITLE</th>
				<th>PUBLISHER</th>
				<th>PRICE</th>
			</tr>
			<%
			for(Book book : list){
			%>
			<tr>
				<td>ID : <%= book.getId() %></td>
				<td>TITLE : <%= book.getTitle() %></td>
				<td>PUBLISHER : <%=book.getPublisher() %></td>
				<td>PRICE : <%=book.getPrice() %></td>			
			</tr>
			<%
			}
			%>				
		</table>
	<%
	}
	%>		
	
</body>
</html>