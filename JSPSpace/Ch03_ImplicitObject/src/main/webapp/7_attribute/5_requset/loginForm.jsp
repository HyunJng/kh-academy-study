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
<title>Login</title>
</head>
<body>
	<form action="loginProcedure.jsp" method="post">
		<table>
			<tr>
				<th>아이디</th>			
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<th>비밀번호</th>			
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인"/></td>
			</tr>
		</table>
		
	</form>
</body>
</html>