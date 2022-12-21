<%@page import="user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%	UserVO user = (UserVO) session.getAttribute("authUser"); %>
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
<script type="text/javascript" src="./script/signUpscript.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입</h1>
	<p>'*' 표시 항목은 필수 입력 항목입니다.</p>
	<form method="get" action="insertSign.do" id="frm">
			<label>이름</label><input type="text" name="name" id="name" required="required"> *<br> 
			<label>아이디</label><input type="text" name="id" id="id"> * <input type="button" id="btn" value="중복 확인" required="required"><span id="s1"></span><br>
			<label>암호</label><input type="password" name="password" id="password" required="required"
			pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()_-+=[]{}~?:;`|/]).{6,50}$" > *<span id="s2"></span><br>
			<label>암호 확인</label><input type="password" required="required" id="pwdch" > *<span id="s3"></span><br>
			<label>이메일</label><input type="text" name="email" id="email"><br>
			<label>전화번호</label><input type="text" name="tel" id="tel"><br>
			<label>등급</label><input type="radio" name="role" id="role" value="user">일반회원
			<input type="radio" name="role" id="role" value="admin" <c:if test="${urole != 'admin'}"> disabled</c:if> />관리자<br>
			<input type="submit" id="check" value="확인">
			<input type="button" id="cancle" value="취소" onClick="location.href='./login.jsp'">
	</form>
	<input type="hidden" name="idChk" value="invalid" />
	<input type="hidden" name="pwChk" value="invalid" />
	<input type="hidden" name="pwPtChk" value="invalid" />
</body>
</html>