<%@page import="user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%
	UserVO user = (UserVO) session.getAttribute("authUser");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="urole" value="<%=user.getRole() %>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
label {
	width: 100px;
	float: left;
}
input {
	margin: 1px;
}
</style>
<script type="text/javascript" src="./script/signchscript.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 변경</h1>
	<form method="post" action="updateSign.do" id="frm">
			<label>이름</label><input type="text" name="name" id="name" value="<%=user.getName() %>" required="required"><br> 
			<label>아이디</label><input type="text" name="id" id="id" value="<%=user.getId() %>" disabled><br>
			<label>현재 암호</label><input type="password" id="pwd" required="required"><br>
			<label>암호</label><input type="password" name="password" id="password"
			pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()_-+=[]{}~?:;`|/]).{6,50}$"><span id="s2"></span><br>
			<label>암호 확인</label><input type="password" id="pwdch"><span id="s3"></span><br>
			<label>이메일</label><input type="text" name="email" id="email" value="<%=user.getEmail() %>"><br>
			<label>전화번호</label><input type="text" name="tel" id="tel" value="<%=user.getTel() %>"><br>
			<label>등급</label>
			<input type="radio" name="role" id="role" value="user" <c:if test="${urole == 'user'}"> checked ="checked"</c:if> />일반회원
			<input type="radio" name="role" id="role" value="admin" <c:if test="${urole == 'admin'}"> checked ="checked"</c:if> disabled/>관리자<br>
			<input type="submit" id="check" value="확인" />
			<input type="button" id="cancle" value="취소" onClick="location.href='getBoardList.jsp'">
			<input type="button" id="delete" value="회원탈퇴" onClick="location.href='deleteSign.do'">
	</form>
	<input type="hidden" name="pwChk" value="valid" />
	<input type="hidden" name="pwPtChk" value="valid" />
	<input type="hidden" id="Cpwd" value="<%=user.getPassword() %>" />
</body>
</html>