<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/admin/main.css">
<title>Insert title here</title>
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
			<div id="admin-menu" class="col-3 btn-group-vertical justify-content-start">
				<button class="btn btn-outline-secondary" type="button" onclick="location.href='/admin/addGoods'">상품 등록</button>	
				<button class="btn btn-outline-secondary" type="button" onclick="location.href='/admin/manageGoods'">상품 관리</button>	
				<button class="btn btn-outline-secondary" type="button" onclick="location.href='/admin/manageMember'">회원 관리</button>	
			</div>
			<div class="col-9">
				<div id="admin_subtitle" class="py-2 ps-2">
					<h4>상품 등록</h4>
				</div>
			</div>
		</div>
	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/fix/footer.jsp"></jsp:include>
	</footer>
</body>
</html>