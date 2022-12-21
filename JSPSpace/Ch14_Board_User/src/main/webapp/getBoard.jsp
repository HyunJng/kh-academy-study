<%@page import="board.model.impl.BoardDAO"%>
<%@page import="board.model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 상세</h1>
	<form action="updateBoard.do" method="post">
		<input name="seq" type="hidden" value="${board.seq }">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td bgColor="orange" width="70">제목</td>
				<td align="left" colspan="3"><input type="text" name="title" value="${board.title }" size="28"/></td>
			</tr>
			<tr>
				<td bgColor="orange" width="70">작성자</td>
				<td align="left" colspan="3">${board.writer }</td>
			</tr>
			<tr>
				<td bgColor="orange" width="70">내용</td>
				<td align="left" colspan="3"><textarea name="content" rows="10" cols="30" resize="none">${board.content }</textarea></td>
			</tr>
			<tr>
				<td bgColor="orange" width="70">등록일</td>
				<td align="left" colspan="3">${board.regDate }</td>
			</tr>
			<tr>
				<td bgColor="orange" width="70">조회수</td>
				<td align="left" >${board.cnt+1 }</td>
			</tr>
		</table>
		<br>
		<table>
			<tr>
				<td width="307" align="right" colspan="2">
					<input type="button" value="글 작성" onclick="location.href='insertBoard.jsp'">&nbsp;&nbsp;&nbsp;
					<input type="button" value="글 삭제" onclick="location.href='deleteBoard.do?seq=${board.seq }'">&nbsp;&nbsp;&nbsp;
					<input type="button" value="글 목록" onclick="location.href='getBoardList.do'">&nbsp;&nbsp;&nbsp;
					<input type="submit" value="글 수정">
				</td>
			</tr>
		</table>
		
	</form>
</body>
</html>