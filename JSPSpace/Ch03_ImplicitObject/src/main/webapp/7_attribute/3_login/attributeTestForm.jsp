<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application Attribute Test</title>
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
</head>
<body>
	<form action="attributeTest1.jsp" method="get">
		<table>
			<tr>
				<td colspan="2">Application에 저장될 attribute</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"> </td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="전송"> </td>
			</tr>
		</table>
	</form>
</body>
</html>