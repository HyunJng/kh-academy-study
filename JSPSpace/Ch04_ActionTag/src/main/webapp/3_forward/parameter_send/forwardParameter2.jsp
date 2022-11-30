<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="forwarded2.jsp" method="post">
		<ul>
			<li>아이디 : <input type="text" name="id" id="id" /></li>
			<li>취미 : <select name="hobby" id="hobby">
					<option value="tv">TV보기</option>
					<option value="game">게임하기</option>
					<option value="tennis">테니스하기</option>
			</select>
			</li>
		</ul>
		<input type="submit" value="전송">
	</form>
</body>
</html>