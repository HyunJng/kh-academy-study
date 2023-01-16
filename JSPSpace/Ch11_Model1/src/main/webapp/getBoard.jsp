<%@page import="board.model.impl.BoardDAO"%>
<%@page import="board.model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 1. 검색할 게시글 번호(primary key) 추출
String seq = request.getParameter("seq");

// 2. DB 연동 처리
BoardVO vo = new BoardVO();
vo.setSeq(Integer.parseInt(seq));

BoardDAO boardDAO = new BoardDAO();
BoardVO board = boardDAO.getBoard(vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>글 상세</h1>
	<form action="updateBoard_proc.jsp" method="post">
		<input name="seq" type="hidden" value="<%=board.getSeq()%>">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td bgcolor="orange" width="70">제목</td>
				<td align="left"><input type="text" name="title"
					value="<%=board.getTitle()%>" /></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">작성자</td>
				<td align="left"><%=board.getWriter()%></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">내용</td>
				<td align="left"><textarea name="content" rows="10" cols="40" /><%=board.getContent()%></textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">등록일</td>
				<td align="left"><%=board.getRegDate()%></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">조회수</td>
				<td align="left"><%=board.getCnt()%></td>
			</tr>
			<tr colspan="2" align="center">
				<td><input type="submit" value="글 수정" /></td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
	<a href="deleteBoard_proc.jsp?seq=<%=board.getSeq()%>">글삭제</a>&nbsp;&nbsp;&nbsp;
	<a href="getBoardList.jsp">글목록</a>

</body>
</html>


















