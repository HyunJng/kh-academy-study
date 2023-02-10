<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#admin_title {
		background-color: #B0E0E6;
	}
</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/fix/gnb.jsp"></jsp:include>
	</header>
	<div class="container">
		<div id="admin_title"class="pt-4 pb-4 ps-3">
			<h1>관리자페이지</h1>
		</div>
		<div class="row mt-2">
			<div class="col-3 btn-group-vertical">
				<button class="btn btn-outline-secondary" type="button">상품 등록</button>	
				<button class="btn btn-outline-secondary" type="button">상품 목록</button>	
				<button class="btn btn-outline-secondary" type="button">회원 관리</button>	
			</div>
			<div class="col-9">
			
			</div>
		</div>
	</div>
</body>
</html>