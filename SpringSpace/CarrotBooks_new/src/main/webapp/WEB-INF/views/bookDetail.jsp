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
						적립 포인트: <span class="point_span"></span> point
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
							주문수량: <input type="text" class="quentity_input" value="1">
							<span>
								<button class="plus_btn">+</button>
								<button class="minus_btn">-</button>
							</span>
						</div>
						<div class="my-3">
							<button id="addCart_btn" class="btn btn-secondary">장바구니 담기</button>
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
<script type="text/javascript">
	$(function(){
		/*포인트 삽입*/
 		let salePrice = "${book.fullPrice * (1 - book.discountPer / 100)}";
		console.log(salePrice);
		let point = salePrice * 0.05;
		point = Math.floor(point);
		$(".point_span").text(point);
	});
	
	/* 수량 조절 버튼 조작*/
	$(".plus_btn").on("click", function(){
		let quantity = $(".quentity_input").val();
		$(".quentity_input").val(++quantity);
	});
	
	$(".minus_btn").on("click", function(){
		let quantity = $(".quentity_input").val();
		if(quantity > 1){
			$(".quentity_input").val(--quantity);
		}
	});

	/* 장바구니 추가 */
	const form = {
			bookId : '${book.bookId}',
			bookCount: '',
			memberId : '${member.memberId}'
	}
	// 장바구니 버튼 클릭
	$('#addCart_btn').on("click", function(e){
		form.bookCount = $(".quentity_input").val();
		
		// post로 int값을 공백 넣어주면 에러가 발생하므로 임의의 값 넣기
		if(form.memberId === ""){
			form.memberId = 0;
		}

		$.ajax({
			url: '/cart/add',
			type: 'POST',
			data: form,
			success: function(result){
				console.log("ajax result: "+result);
				if(result == "0"){
					alert("장바구니에 추가를 하지 못하였습니다.");
				} else if(result == "1"){
					alert("장바구니에 추가되었습니다.");
				} else if(result == "2"){
					alert("장바구니에 이미 존재합니다.");
				} else if(result == "5"){
					alert("로그인이 필요합니다.");
					location.href="/member/login";
				}
			}
		});
	});
</script>
</html>