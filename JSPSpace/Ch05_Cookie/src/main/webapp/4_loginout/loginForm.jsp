<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath() %>/4_Loginout/Login.jsp>" method="post">
	아이디 <input type="Text" name="id" size="10"><br>
	암호 <input type="password" name="password" size="10"><br>
	<input type="submit" value="로그인">
</form>


</body>
</html>