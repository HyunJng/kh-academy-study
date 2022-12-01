<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Book primary key로 도서 조회</h3>
	<form action="process.jsp" method="get">
		<fieldset>
			<legend>도서 코드를 입력하세요</legend>
			<input type="text" name="code" required="required">
			<input type="submit" value="조회">
		</fieldset>
	</form>
</body>
</html>