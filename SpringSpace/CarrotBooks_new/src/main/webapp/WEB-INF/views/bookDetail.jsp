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
<style type="text/css">
	#book_detail {
		margin: auto 0;
	}
	#detail_quantity_btn button{
		border: 1px solid grey;
	}
	#detail_quantity_btn input{
		width: 50px;
	}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/fix/gnb.jsp"></jsp:include>
	
	<div class="container">
		<header>
			<jsp:include page="/WEB-INF/views/fix/header.jsp"></jsp:include>
		</header>
		<div>
			<!-- 책 정보 -->
			<div class="row mx-2 py-3 d-flex justify-content-center border-top border-bottom">
				<div class="col-3">
					<img alt="책" src="${book.bookImage}" width="100%">
				</div>
				<div id="book_detail" class="col-8 ps-5">
					<div class="py-2 border-bottom">
						<h4><strong>${book.title }</strong></h4>
					</div>
					<div class="py-2 border-bottom">
						'${book.author }' 지음 | '${book.publisher }' 출판사
					</div>
					<div class="py-2 border-bottom">
						<p>정가: <fmt:formatNumber value="${book.fullPrice }" pattern="##,### 원"/> </p>
						<p>
							판매가: <span class="h5 text-danger"><fmt:formatNumber value="${book.fullPrice * (1 - book.discountPer / 100)}" pattern="##,### 원" /></span>
							<span>[${book.discountPer}% <fmt:formatNumber value="${(book.fullPrice * book.discountPer / 100)}" pattern="##,### 원"/> 할인]</span>
						</p>
					</div>
					<div class="py-2">
						<div id="detail_quantity_btn">
							주문수량: <input type="text" value="1">
							<span>
								<button>+</button>
								<button>-</button>
							</span>
						</div>
						<div class="my-3">
							<button class="btn btn-secondary">장바구니 담기</button>
							<button class="btn btn-light">바로 구매</button>
						</div>
					</div>
				</div>
			</div>
			<!-- 책 내용  -->
			<div class="px-5 py-3">
				<div class="h5">책 소개</div>
				<div>${book.bookIntro}...</div>
			</div>
			<!-- 리뷰 -->
			<div>
				
			</div>
			<div>
				리뷰
			</div>
		</div>
	</div><!-- 헤더 끝 -->
	
	<footer>
		<jsp:include page="/WEB-INF/views/fix/footer.jsp"></jsp:include>
	</footer>
</body>
</html>