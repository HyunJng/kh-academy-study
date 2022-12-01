<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이동할 페이지 선택</title>
</head>
<body>
	<h3>보고 싶은 web page 선택</h3>
	<form action="<%= request.getContextPath()%>/3_forward/practice/view.jsp">
		<select name="code">
			<option value="A">A</option>
			<option value="B">B</option>
			<option value="C">C</option>
		</select>
		<input type="submit" value="이동">
	</form>
</body>
</html>