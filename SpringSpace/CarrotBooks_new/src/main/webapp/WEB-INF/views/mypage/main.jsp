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
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/fix/gnb.jsp"></jsp:include>
	
	<div class="container">
		<header>
			<jsp:include page="/WEB-INF/views/fix/header.jsp"></jsp:include>
		</header>
		<div class="page_sub_header mt-2">
			<h4>#마이페이지</h4>
		</div>
		<div class="row mt-2">
			<div class="col-3">
				<jsp:include page="/WEB-INF/views/fix/mypage_menu.jsp"></jsp:include>
			</div>
			<div class="col-9">
				<h5>#내 정보</h5>
				<table class="table border rounded-4">
					<tr>
						<th>회원이메일</th>
						<td>${member.memberEmail }</td>
					</tr>
					<tr>
						<th>회원 이름</th>
						<td>${member.memberName }</td>
					</tr>
					<tr>
						<th>회원 주소</th>
						<td>(${member.memberAddr1})${member.memberAddr2} ${member.memberAddr3}</td>
					</tr>
					<tr>
						<th>포인트</th>
						<td><fmt:formatNumber value="${member.memberPoint }" pattern="##,### p" /></td>
					</tr>
				</table>
			</div>
		</div>
		
	</div>
	
	<footer>
		<jsp:include page="/WEB-INF/views/fix/footer.jsp"></jsp:include>
	</footer>
</body>
<script type="text/javascript">

</script>
</html>