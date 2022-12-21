<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 전용 페이지</h1>
	<p>안녕하세요 ${authUser.name}(${authUser.id})님</p>
	<button onclick="location.href='loginout.do'">로그아웃</button>
	<button onclick="location.href='modifyUserinfo.jsp'">회원 정보 수정</button>
</body>
</html>