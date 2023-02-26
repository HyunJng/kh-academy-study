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
	#cart_div {
		text-align: center;
	}
	#item_div {
		display: inline-block;
		width: 75%;
		background-color: #fff5ee;
		margin-top: 10px;
	}
	
	#item_div  table tbody tr{
	  border-bottom: 1rem solid;
	  border-color: transparent;
	}

	#item_div table thead tr{
		border-bottom: 4px dashed white;
	}
	#cal_div {
		display: inline-block;
		border: 1px solid black;	
		height: 300px;
		width: 20%;
		position:relative;
	}
	.cart_quantity_btn input[type='number'] {
		width: 40px;
	}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/fix/gnb.jsp"></jsp:include>
	
	<div class="container">
		<header>
			<jsp:include page="/WEB-INF/views/fix/header.jsp"></jsp:include>
		</header>
		<div id="cart_div">
			<div id="item_div" class="rounded-3">
					ㅁㅁㅁ
 				<table>
 					<thead>
 						<tr>
							<th width="18%"></th>
							<th width="*">상품명</th>
 							<th width="25%">상품가</th>
 							<th width="13%">수량</th>
 							<th width="15%">합계</th>
 							<th width="8%">삭제</th>
 						</tr>
 					</thead>
					<tbody class="p-3">
						<c:forEach var="cart" items="${cartList}">
							<tr>
								<td><img alt="책" src="${cart.bookImage}" width="100px"></td>
								<td>${cart.title }</td>
								<td>
									<del>정가: <fmt:formatNumber value="${cart.fullPrice}" pattern="##,###원" /></del><br> 
									판매가: <strong class="text-danger"><fmt:formatNumber value="${cart.salePrice }" pattern="##,###원" /></strong><br>
									포인트: <span class="text-success"><fmt:formatNumber value="${cart.point}" pattern="##,###p"/></span>
								</td>
								<td>
									<div class="cart_quantity_btn">
										<input type="number" value="${cart.bookCount}" min="1" max="100"> 
										<button class="btn btn-sm btn-secondary" type="button">변경</button>
									</div>
								</td>
								<td>
									<fmt:formatNumber value="${cart.totalPrice}" pattern="##,###원"/>
								</td>
								<td>
									<button class="btn btn-sm btn-outline-danger" type="button">X</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div id="cal_div">
				<div>
					<div>
						d
					</div>

				</div>
			</div>
		</div>
	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/fix/footer.jsp"></jsp:include>
	</footer>
</body>
<script type="text/javascript">
	$(function(){
		/* 결제 내역 스크롤 처리 */
		$(window).scroll(function(){
			$('#cal_div').css('top',$(window).scrollTop());
		});
	
	});
</script>
</html>