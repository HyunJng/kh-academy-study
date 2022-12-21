<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	ul {
		list-style-type : none;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<h1>회원 수정</h1>
	<ul>
		<li>이름 <input type="text" value="${authUser.name }"></li>
		<li>아이디 <input type="text" value="${authUser.id }"></li>
		<li>암  호 <input type="text" value="${authUser.password}"></li>
		<li>암호확인<input type="text" value=""></li>
		<li>이메일<input type="text" value="${authUser.email}"></li>
		<li>전화번호<input type="text" value="${authUser.tel }"></li>
		<li>등급<input type="text" value="${authUser.level}"></li>
	</ul>
</body>
</html>