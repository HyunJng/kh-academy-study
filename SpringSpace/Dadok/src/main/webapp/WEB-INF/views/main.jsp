<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/main.css">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<header>
		<jsp:include page="/WEB-INF/views/fix/gnb.jsp"></jsp:include>
	</header>
	
	<div class="wrap">
		<div class="top_area">
			<div class="logo_area">
				<h1>logo area</h1>
			</div>
			<div class="search_area">
				<h1>Search area</h1>
			</div>
			<div class="login_area">
				<c:if test="${member == null}">
					<div>
						<div class="login_button"><a href="/member/login">로그인</a></div>
						<span><a href="/member/join">회원가입</a></span>
					</div>
				</c:if>
				<c:if test="${member != null}">
					<div>
						<span>${member.memberName}님 안녕하세요</span>
						<span>포인트: <fmt:formatNumber value="${member.memberPoint}" pattern="#,###"/></span>
						<a href="/member/logout">로그아웃</a>
					</div>
				</c:if>
				
			</div>
			<div class="clearfix"></div>			
		</div>
		<div class="navi_bar_area">
			<h1>navi area</h1>
		</div>
		<div class="content_area">
			<h1>content area</h1>
		</div>
	</div>
</div>
</body>
</html>