<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 -->
 <link rel="stylesheet" href="/resources/css/overall.css">
<link rel="stylesheet" href="/resources/css/fix/gnb.css">
<link rel="shortcut icon" href="#">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="container" class="container sticky-top">
		<div class="d-flex justify-content-end gnd_back">
			<ul id="link_list" class="list-group list-group-flush list-group-horizontal">
				<c:if test='${member == null}'>
					<li class="list-group-item">
						<a href="/member/login">로그인</a>
					</li>
					<li class="list-group-item">
						<a href="/member/join">회원가입</a>
					</li>
				</c:if>
				<li class="list-group-item">
						${member.memberName}관리자입니다.
						<a href="/main">메인페이지</a>
				</li>
				<c:if test='${member != null}'>
					<li class="list-group-item">
						<a href="/member/logout">로그아웃</a>
					</li>
					<li class="list-group-item">
						<a href="/mypage/main">마이룸</a>
					</li>
					<li class="list-group-item">
						<a href="/cart/${member.memberId}">장바구니</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>