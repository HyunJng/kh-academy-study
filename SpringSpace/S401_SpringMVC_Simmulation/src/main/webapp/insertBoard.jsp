<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글 등록</title>
</head>
<body>
<h1>게시글 등록</h1>
<a href="logout.do">Log-out</a>
<hr>

<form action="insertBoard.do" method="post">
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">제목</td>
		<td align="left"><input type="text" name="title" /></td>
	</tr>
	<tr>
		<td bgcolor="orange" width="70">작성자</td>
		<td align="left"><input type="text" name="writer" size="10" /></td>
	</tr>
	<tr>
		<td bgcolor="orange" width="70">내용</td>
		<td align="left"><textarea name="content" rows="10" cols="40" /></textarea></td>
	</tr>
	<tr colspan="2" align="center">
		<td><input type="submit" value="새글 등록" /></td>
	</tr>
</table>
</form>
<hr>
<a href="getBoardList.jsp">글 목록 가기</a>

</body>
</html>





















