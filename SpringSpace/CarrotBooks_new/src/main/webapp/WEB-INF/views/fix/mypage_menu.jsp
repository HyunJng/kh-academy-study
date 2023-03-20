<%@page import="java.util.List"%>
<%@page import="com.carrot.domain.AttachImageVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.mypage_menu {
	background-color: #ffefd5	 !important;
}
</style>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="d-flex flex-column">
		<button class="btn mypage_menu" onclick="location.href='/mypage/main'">내 정보</button>
		<button class="btn mypage_menu" onclick="location.href='/mypage/myreply/${member.memberId}'">내가작성한댓글</button>
		<button class="btn mypage_menu" >구매내역</button>
	</div>
</body>
</html>