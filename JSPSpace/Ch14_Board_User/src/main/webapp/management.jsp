<%@page import="user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%	UserVO user = (UserVO) session.getAttribute("authUser"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>관리자 메뉴</h1>
	<h3>안녕하세요 관리자님<h3>
	<h3>
		<input type="button" value="로그아웃" onClick="location.href='logout.do'" />
		<input type="button" value="게시판" onClick="location.href='getBoardList.do'" >
	</h3>
	<!-- 게시글 -->
	<form action="manageDelete.do" method="post">
		<table border ="1" cellpadding="0" width="700">
			<tr>
				<th bgColor="orange" width="50"></th>
				<th bgColor="orange" width="100">번호</th>
				<th bgColor="orange" width="150">제목</th>
				<th bgColor="orange" width="150">작성자</th>
				<th bgColor="orange" width="150">등록일</th>
				<th bgColor="orange" width="100">조회수</th>
			</tr>
			<c:forEach items="${boardList }" var="board">
				<tr>
					<td align="center"><input type="checkbox" value="${board.seq }" name="seqch"></td>
					<td>${board.seq }</td>
					<td align="left"><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
					<td>${board.writer }</td>
					<td>${board.regDate }</td>
					<td>${board.cnt }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6" align="right"><input type="submit" value="삭제" ></td>
			</tr>
		</table>
	</form>
	<br>
	<!-- 유저 -->
	<form action="manageDelete.do" method="post">
		<table border ="1" cellpadding="0" width="700">
			<tr>
				<th bgColor="orange" width="50"></th>
				<th bgColor="orange" width="130">ID</th>
				<th bgColor="orange" width="130">이름</th>
				<th bgColor="orange" width="130">이메일</th>
				<th bgColor="orange" width="130">전화번호</th>
				<th bgColor="orange" width="130">등급</th>
			</tr>
			<c:forEach items="${userList }" var="user">
				<tr align="center">
					<td><input type="checkbox" value="${user.id }" name="idch"></td>
					<td>${user.id }</td>
					<td>${user.name }</td>
					<td>${user.email }</td>
					<td>${user.tel }</td>
					<td>${user.role }</td>
				</tr>
			</c:forEach>
			<tr>
					<td colspan="6" align="right"><input type="submit" value="삭제" ></td>
			</tr>
		</table>
	</form>
</body>
</html>