<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>기존 jsp코딩 방식</h3>
<p>아이디 : <%=request.getParameter("id") %></p>
<p>비밀번호 : <%=request.getParameter("pwd") %></p>

<h3>EL사용방식</h3>
<p>아이디 : ${param.id }</p>
<p>비밀번호 : ${param.pwd }</p>
</body>
</html>