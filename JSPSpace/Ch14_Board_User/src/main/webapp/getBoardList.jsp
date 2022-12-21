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
	<h1>게시판</h1>
	<h3>안녕하세요
		<c:set var="role" value="<%= user.getRole() %>" />
		<c:if test="${role == 'user'}"><%=user.getName() + "(" + user.getId() + ")" %>님</c:if>
		<c:if test="${role == 'admin'}">관리자님</c:if>
	</h3>
	<h3>
		<c:if test="${role == 'user'}"><input type="button" value="회원정보변경" onClick="location.href='./signch.jsp'" ></c:if>
		<c:if test="${role == 'admin'}"><input type="button" value="관리자메뉴" onClick="location.href='management.do'" ></c:if>
		<input type="button" value="로그아웃" onClick="location.href='logout.do'" />
	</h3>
	
	<!-- 검색 시작 -->
	<form action="getBoardList.do" method="post">
		<table border ="1" cellpadding="0" width="700">
			<tr>
				<td align="right">
					<select name="searchCondition">
						<option value="TITLE">제목</option>
						<option value="CONTENT">내용</option>
					</select>
					<input name="searchKeyword" type="text">
					<input type="submit" value="검색">
				</td>
			</tr>
		</table>
	</form>
	<!-- 검색 결과 조회 테이블 -->
	<table border ="1" cellpadding="0" width="700">
		<tr>
			<th bgColor="orange" width="100">번호</th>
			<th bgColor="orange" width="200">제목</th>
			<th bgColor="orange" width="150">작성자</th>
			<th bgColor="orange" width="150">등록일</th>
			<th bgColor="orange" width="100">조회수</th>
		</tr>
		<c:forEach items="${boardList }" var="board">
			<tr>
				<td>${board.seq }</td>
				<td align="left"><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
				<td>${board.writer }</td>
				<td>${board.regDate }</td>
				<td>${board.cnt }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="right"><input type="button" value="새 글 등록" onClick="location.href='./insertBoard.jsp'" />	</td>
		</tr>
	</table>
	<br>
	<table>
		
	</table>
</body>
</html>