<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session에 attribute 설정</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String emailaddr= request.getParameter("emailaddr");
	String address = request.getParameter("address");
	String telephone = request.getParameter("telephone");
	
	response.setContentType("text/html;charset=utf-8");
	
	session.setAttribute("emailaddr", emailaddr);
	session.setAttribute("address", address);
	session.setAttribute("telephone", telephone);
	%>
	
	<p>홍길동님의 정보가 모두 저장되었습니다.</p>
	<a href="attributeTest3.jsp">확인하러 가기</a>
</body>
</html>