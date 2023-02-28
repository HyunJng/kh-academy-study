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
<link rel="stylesheet" href="/resources/css/cart.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/fix/gnb.jsp"></jsp:include>
	
	<div class="container">
		<header>
			<jsp:include page="/WEB-INF/views/fix/header.jsp"></jsp:include>
		</header>
		<div class="page_sub_header">
			<h4>#장바구니</h4>
		</div>
		<div id="cart_div" class="row p-1">
			<div id="item_div" class="rounded-3 col-8 mx-3">
 				<table>
 					<thead>
 						<tr>
							<th width="5%">
								<input type="checkbox" id="all_check" checked>
							</th>
							<th width="18%"></th>
							<th width="*">상품명</th>
 							<th width="25%">상품가</th>
 							<th width="13%">수량</th>
 							<th width="15%">합계</th>
 							<th width="8%">삭제</th>
 						</tr>
 					</thead>
					<tbody >
						<c:forEach var="cart" items="${cartList}">
							<tr>
								<td class="cart_info_td">
									<input type="checkbox" class="cart_info_checkbox" checked>
									<input type="hidden" class="cart_info_cartId " value="${cart.cartId }">
									<input type="hidden" class="cart_info_memberId " value="${cart.memberId}">
									<input type="hidden" class="cart_info_fullPrice " value="${cart.fullPrice }">
									<input type="hidden" class="cart_info_salePrice " value="${cart.salePrice }">
									<input type="hidden" class="cart_info_bookCount " value="${cart.bookCount }">
									<input type="hidden" class="cart_info_point " value="${cart.point }">
									<input type="hidden" class="cart_info_bookId " value="${cart.bookId}">
								</td>
								<td><img alt="책" src="${cart.bookImage}" width="100px"></td>
								<td>${cart.title }</td>
								<td>
									<del>정가: <fmt:formatNumber value="${cart.fullPrice}" pattern="##,###원" /></del><br> 
									판매가: <strong class="text-danger"><fmt:formatNumber value="${cart.salePrice }" pattern="##,###원" /></strong><br>
									포인트: <span class="text-success"><fmt:formatNumber value="${cart.point}" pattern="##,###p"/></span>
								</td>
								<td class="cart_quantity_td">
									<input type="number" value="${cart.bookCount}" min="1" max="100"> 
								</td>
								<td class="cart_totalPrice_td">
									<fmt:formatNumber value="${cart.totalPrice}" pattern="##,###원"/>
								</td>
								<td>
									<button class="btn btn-sm btn-outline-danger delete_btn" data-cartid="${cart.cartId}" type="button">X</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div id="cal_div" class="rounded-3 col-3">
				<table class="table">
					<tr>
						<th colspan="2">결제 정보</th>
					</tr>
				</table>
				<table class="table table-borderless">
					<tr>
						<td>총 금액</td>
						<td class="output_totalPrice"></td>
					</tr>
					<tr>
						<td>배송비</td>
						<td class="output_delivaryPrice"></td>
					</tr>
					<tr>
						<td>총 상품수</td>
						<td class="output_totalCount"></td>
					</tr>
					<tr>
						<td>총 상품종류</td>
						<td class="output_totalKind"></td>
					</tr>
				</table>
				<table class="table table-borderless table-secondary">
					<tr>
						<td>총 결제</td>
						<td class="output_finalTotalPrice"></td>
					</tr>
					<tr>
						<td>총 포인트</td>
						<td class="output_totalPoint"></td>
					</tr>
				</table>
				<div class="d-grid">
					<button id="order_btn" class="btn btn-warning btn-block" >결제하기</button>
				</div>
			</div>
		</div>
	</div>
	
	<div>
		<!-- 삭제 form -->
		<form class="delete_form" action="/cart/delete" method="post" >
			<input type="hidden" name="cartId">
			<input type="hidden" name="memberId" value="${member.memberId}">
		</form>
		<!-- 주문 form  -->
		<form action="/order/${member.memberId}" method="get" class="order_form">
		</form>
	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/fix/footer.jsp"></jsp:include>
	</footer>
</body>
<script type="text/javascript">
	let totalKind = 0; // 결제할 상품 종류 수 확인 용
	
 	$(function(){
		/* 결제 내역 스크롤 처리 */
		$(window).scroll(function(){
			$('#cal_div').css('top',$(window).scrollTop());
		});
	
		/* 종합 정보 출력 */
		setTotalInfo();
	});

	/* 주문 버튼 클릭 */
	$("#order_btn").on("click", function(e){
		e.preventDefault();
		
		let form_contents = '';
		let orderNumber = 0;
		
		$(".cart_info_td").each(function(index, element){
			if($(element).find(".cart_info_checkbox").is(":checked") === true){
				let bookId = $(element).find(".cart_info_bookId").val();
				let bookCount = $(element).find(".cart_info_bookCount").val();
				
				let bookId_input = "<input type='hidden' name='orders["+orderNumber + "].bookId' value='" + bookId + "'>";
				let bookCount_input = "<input type='hidden' name='orders["+orderNumber + "].bookCount' value='" + bookCount + "'>";
				
				form_contents += bookId_input;
				form_contents += bookCount_input;
				
				orderNumber++;
			}
		});
		
		$(".order_form").append(form_contents);
		$(".order_form").submit();
	})
	
	/* 카트 삭제 */
	$(".delete_btn").on("click", function(e){
		e.preventDefault();
		const cartId = $(this).data("cartid");
		$(".delete_form").find("input[name='cartId']").val(cartId);
		$(".delete_form").submit();
	});
	
	/* 수량 변경시 업데이트*/
	$(".cart_quantity_td").find("input[type='number']").on("change", function(){
		let cartInfoObj = $(this).closest(".cart_quantity_td").siblings(".cart_info_td");
		let cartId = cartInfoObj.find(".cart_info_cartId").val();
		let bookCount = $(this).val();
		let cartSalePrice = cartInfoObj.find(".cart_info_salePrice").val();
		let memberId = cartInfoObj.find(".cart_info_memberId").val();
		const form = {
				"cartId" : cartId,
				"bookCount": bookCount
		}
		
		// DB업데이트
		$.ajax({
			url: '/cart/update',
			type: 'POST',
			data: form,
			success: function(result){
				if(result !== "true"){
					alert("오류입니다. 다시 시도해주세요");
					window.location.href ="/cart/"+memberId;
				}
			}
		});
		
		// view 수정
		cartInfoObj.find(".cart_info_bookCount").val(bookCount);
 		setTotalInfo();
 		$(this).closest(".cart_quantity_td").siblings(".cart_totalPrice_td").text((cartSalePrice * bookCount).toLocaleString() + "원" );
	});
	
 	/* 체크박스에 따른 종합정보 변화 */
 	$(".cart_info_checkbox").on("change", function(){
 		setTotalInfo();
 		
 		// 개별에 따른 전체 선택 체크 변화
 		let totalCount = $(".cart_info_td").length;

		if(totalCount === totalKind){
			$("#all_check").prop("checked", true);
		} else {
			$("#all_check").prop("checked", false);
		}
 	});
 	
 	/* 전체 선택 */
 	$("#all_check").on("click", function(){
 		if($("#all_check").prop("checked")){
 			$(".cart_info_checkbox").prop("checked", true);
 		}else {
 			$(".cart_info_checkbox").prop("checked", false);
 		}
 		
 		setTotalInfo();
 	});
 	
 	/* 종합정보 출력 메서드 */
 	function setTotalInfo(){
		let totalPrice = 0;
		let totalCount = 0;
		totalKind = 0;
		let totalPoint = 0;
		let deliveryPrice = 0;
		let finalTotalPrice = 0; // 최종 가격(총가격 + 배송비)
		
		$(".cart_info_td").each(function(index, element){
			
			if($(element).find(".cart_info_checkbox").is(":checked") === true){
				let tempBookCount = $(element).find(".cart_info_bookCount").val();
				// 총 가격 
				totalPrice += parseInt($(element).find(".cart_info_salePrice").val() * tempBookCount);
				// 총 개수
				totalCount += parseInt(tempBookCount);
				// 총 종류
				totalKind += 1;
				// 총 포인트
				totalPoint += parseInt($(element).find(".cart_info_point").val() * tempBookCount);
			}
		});
		
		if(totalPrice >= 20000) { // 배송비
			deliveryPrice = 0;
		} else if(totalPrice == 0){
			deliveryPrice = 0;
		} else {
			deliveryPrice = 3000;
		}
		
		// 최종가격
		finalTotalPrice = totalPrice + deliveryPrice;
		
		$(".output_totalPrice").text(totalPrice.toLocaleString() + " 원");
		$(".output_delivaryPrice").text(deliveryPrice.toLocaleString() + " 원");
		$(".output_totalCount").text(totalCount + " 개");
		$(".output_totalKind").text(totalKind + " 종류");
		$(".output_finalTotalPrice").text(finalTotalPrice.toLocaleString() + " 원");
		$(".output_totalPoint").text(totalPoint.toLocaleString() + " p");
 	}
</script>
</html>