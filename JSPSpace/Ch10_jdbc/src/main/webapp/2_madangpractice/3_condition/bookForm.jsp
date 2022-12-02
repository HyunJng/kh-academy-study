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
			<legend>검색 조건을 입력하시오</legend>
			<select name="condition">
				<option value="c">코드</option>
				<option value="t">제목</option>
				<option value="p">출판사</option>
				<option value="tp">제목+출판사</option>
			</select>
			<input type="text" name="val">
			<input type="submit" value="조회">
		</fieldset>
	</form>
</body>
</html>