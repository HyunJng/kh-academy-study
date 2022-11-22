<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	table, td {
		border: 1px solid black;
	}
	table {
	border-collapse: collapse;
	}
	input[type=text] {
	border: none;
	}
</style>
<title>Attribute 정보 가져오기</title>
</head>
<body>
	<h3>Session, Application attribute 정보 가져오기</h3>
	<%
	request.setCharacterEncoding("UTF-8");
	String name = (String) application.getAttribute("name");
	String id = (String) application.getAttribute("id");
	String emailaddr = (String)session.getAttribute("emailaddr");
	String address = (String)session.getAttribute("address");
	String telephone = (String)session.getAttribute("telephone");
	
	response.setContentType("text/html;charset=utf-8");
	%>
	
	<table>
			<tr>
				<th colspan="2">Application에 저장된 attribute</th>
			</tr>
			<tr>
				<td>이름</td>
				<td><%= name %> </td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><%= id %></td>
			</tr>
			
			<tr>
				<th colspan="2">Session에 저장된 attribute</th>
			</tr>
			<tr>
				<td>이메일주소</td>
				<td><%= emailaddr%> </td>
			</tr>
			<tr>
				<td>집주소</td>
				<td><%= address%></td>
			</tr>			
			<tr>
				<td>전화번호</td>
				<td><%= telephone%></td>
			</tr>
			
		</table>
</body>
</html>