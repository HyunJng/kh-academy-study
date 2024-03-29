<%@page import="java.util.List"%>
<%@page import="board.model.impl.BoardDAO"%>
<%@page import="board.model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
BoardVO vo = new BoardVO();
BoardDAO boardDAO = new BoardDAO();

//검색조건 parameter check 해야한다.
String searchCondition = request.getParameter("searchCondition");
String searchKeyword = request.getParameter("searchkeyword");

vo.setSearchCondition(searchCondition);
vo.setSearchKeyword(searchKeyword);
List<BoardVO> boardList = boardDAO.getBoardList(vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>글 목록</h1>
<h3>테스트님 환영합니다...<a href="logout_proc.jsp">Log-out</a></h3>

<!-- 검색 시작 -->
<form action="getBoardList.jsp" method="post">
<table border="1" cellpadding="0" width="700">
	<tr>
		<td align="right">
			<select name="searchCondition">
				<option value="TITLE">제목
				<option value="CONTENT">내용
			</select>
			<input name="searchkeyword" type="text">
			<input type="submit" value="검색">
		</td>
	</tr>
</table>
</form>

<!-- 검색 결과 조회 테이블 -->
<table border="1" cellpadding="0" width="700">
	<tr>
		<th bgColor="orange" width="100">번호</th>
		<th bgColor="orange" width="200">제목</th>
		<th bgColor="orange" width="150">작성자</th>
		<th bgColor="orange" width="150">등록일</th>
		<th bgColor="orange" width="100">조회수</th>
	</tr>
	
	<%
	for (BoardVO board : boardList) {
	%>
	<tr>
		<td><%=board.getSeq() %></td>
		<td align="left"> <a href="getBoard.jsp?seq=<%=board.getSeq() %>"><%=board.getTitle() %></a> </td>
		<td><%=board.getWriter() %></td>
		<td><%=board.getRegDate() %></td>
		<td><%=board.getCnt() %></td>
	</tr>
		
	<%
	}
	%>
</table>
<br>
<a href="insertBoard.jsp">새글 등록</a>
</center>
</body>
</html>














