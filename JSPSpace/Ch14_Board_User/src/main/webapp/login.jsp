<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="login.do" method="post">
		<table>
			<tr>
				<td width="70">아이디</td>
				<td colspan="2"><input type="text" name="id" id="id" /></td>
			</tr>
			<tr>
				<td width="70">암&nbsp;&nbsp;&nbsp;호</td>
				<td colspan="2"><input type="password" name="password" id="password" /></td>
			</tr>
			<tr align="center">
				<td width="70"></td>
				<td width="70"><input type="submit" value="로그인"></td>
				<td width="70"><input type="button" value="회원가입" onClick="location.href='./signup.jsp'"></td>
			</tr>
		</table>
	</form>
</body>
</html>