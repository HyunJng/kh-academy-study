<%@page import="user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%UserVO user = (UserVO) session.getAttribute("authUser"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 등록</title>
<style type="text/css">
	textarea {
		resize: none;
	}
</style>
</head>
<body>
	<h1>게시글 등록</h1>
	<form action="insertBoard.do" method="post">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td bgColor="orange" width="70">제목</td>
				<td align="left"><input type="text" name="title" size="28" /></td>
			</tr>
			<tr>
				<td bgColor="orange" width="70">작성자</td>
				<td align="left"><%= user.getName() %></td>
			</tr>
			<tr>
				<td bgColor="orange" width="70">내용</td>
				<td align="left"><textarea name="content" rows="13" cols="30" resize="none"></textarea></td>
			</tr>
		</table>
		<br>
		<table>
		<tr>
			<td width="307" align="right" colspan="2">
				<input type="submit" value="새 글 등록">&nbsp;&nbsp;&nbsp;
				<input type="button" value="글 목록" onclick="location.href='getBoardList.do'">
			</td>
		</tr>
		</table>
	</form>
</body>
</html>