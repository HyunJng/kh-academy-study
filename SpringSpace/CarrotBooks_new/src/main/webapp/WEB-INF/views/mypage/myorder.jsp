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
.empty_div {
	padding-top: 80px;
	width: 100%;
	height: 300px;
}
.empty_div h5 {
	text-align: center;
	margin: auto;
}
</style>
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
				<h5>#주문 내역</h5>
				<c:if test="${orderListCheck == 'empty'}">
					<div class="empty_div">
						<h5>아직 구매내력이 없습니다</h5>
					</div>
				</c:if>
				<c:if test="${orderListCheck != 'empty'}">
					<table class="table">
						<colgroup>
		                    <col width="21%">
		                    <col width="15%">
		                    <col width="20%">
		                    <col width="10%">
		                    <col width="10%">
						</colgroup>
						<thead>
							<tr>
								<th>주문ID</th>
								<th>주문상태</th>
								<th>주문일</th>
								<th>취소</th>
								<th>주문상세</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="order" items="${orderList}">
								<tr>
									<td>${order.orderId}</td>
									<td>${order.orderState}</td>
									<td><fmt:formatDate value="${order.orderDate}" pattern="yyyy-MM-dd"/></td>
									<td>
										<c:if test="${order.orderState =='배송준비'}">
											<button class="btn btn-sm btn-danger delete_btn" data-orderid="${order.orderId}">X</button>
										</c:if>
										<c:if test="${order.orderState !='배송준비'}">
											<button class="btn btn-sm btn-secondary" data-orderid="${order.orderId}" disabled>X</button>
										</c:if>
									</td>
									<td><button class="btn btn-sm btn-secondary orderChk_btn" data-orderid="${order.orderId}"  data-bs-toggle="modal" data-bs-target="#orderDetail_modal">click</button></td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
	
					<form class="d-flex justify-content-center" id="pageForm" method="get">
						<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
						<ul class="pagination">
							<c:if test="${pageMaker.prev}">
								<li class="page-item"><a class="page-link" href="${pageMaker.startPage-1}">Previous</a></li>
							</c:if>
							<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
								<li class="page-item ${pageMaker.cri.pageNum == num ? 'active':'' }"><a class="page-link" href="${num}" >${num}</a></li>
							</c:forEach>
							<c:if test="${pageMaker.next }">
								<li class="page-item"><a class="page-link" href="${pageMaker.endPage+1}">Next</a></li>
							</c:if>
						</ul>
					</form>
				</c:if>
			</div>
				
			<!--  주문 상세 모달창  -->
			<div class="modal" id="orderDetail_modal">
			  <div class="modal-dialog modal-lg">
			    <div class="modal-content">
			
			      <!-- 모달 헤더 -->
			     <div class="modal-header">
					<h4 class="modal-title">주문상세정보</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				 </div>
			
			      <!-- 모달 바디-->
			      <div class="modal-body">
			        <table class="table border border-secondary">
						<tr>
							<th width="30%">수신자</th>
							<td width="70%" class="modal_addressee"></td>
						</tr>
						<tr>
							<th>배송지</th>
							<td class="modal_memberAddr"></td>
						</tr>
						<tr>
							<th>주문일</th>
							<td class="modal_orderDate"></td>
						</tr>
						<tr>
							<th>배송비</th>
							<td class="modal_deliveryCost"></td>
						</tr>
						<tr>
							<th>사용포인트</th>
							<td class="modal_usePoint"></td>
						</tr>
						<tr>
							<th>결제금액</th>
							<td class="modal_orderSalePrice"></td>
						</tr>
						<tr>
							<th>적립포인트</th>
							<td class="modal_orderSavePoint"></td>
						</tr>
						<tr>
							<th>주문상태</th>
							<td class="modal_orderState"></td>
						</tr>
			        </table>
			        
					<hr class="mt-4">
					<h5 class="mt-4"># 구매목록</h5>
					<table class="table">
						<thead>
							<tr>
								<th width="25%"></th>
								<th width="50%">책이름</th>
							    <th width="10%">개수</th>
							    <th width="15%">가격</th>
							</tr>
						</thead>
						<tbody class="orderItemList">
						</tbody>
					</table>
			      </div>
				  
	
			      <!-- 모달 푸터 -->
			      <div class="modal-footer">
			        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
			      </div>
			
			    </div>
			  </div>
			</div>
					
			
			<div>
				<!-- 주문 취소 form -->
				<form id="deleteForm" action="/mypage/orderCancle" method="post">
					<input type="hidden" name="orderId">			
					<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
					<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
					<input type="hidden" name="memberId" value="${member.memberId}">			
				</form>
			</div>
			
		</div>
	</div>
	
	<footer>
		<jsp:include page="/WEB-INF/views/fix/footer.jsp"></jsp:include>
	</footer>
</body>
<script type="text/javascript">
/* 주문 취소 버튼 */
$(".delete_btn").on("click", function(e){
	e.preventDefault();
	let id = $(this).data("orderid");

	$("#deleteForm").find("input[name='orderId']").val(id);
	$("#deleteForm").submit();
})


/* 페이지 버튼 */
$("#pageForm a").click(function(e) {
	e.preventDefault();
	$("#pageForm").find("input[name='pageNum']").val($(this).attr("href"));
	$("#pageForm").attr("action", "/mypage/orderlist/${memberId}");
	$("#pageForm").submit();
});

/* 주문 상세 버튼 클릭 */
$(".orderChk_btn").on("click", function(e){
	e.preventDefault();

	let orderId = $(this).data("orderid");
	$.getJSON('/admin/orderDetail/' + orderId, function(result){
		console.log(result);
		printOrderInfo(result.orderInfo);
		printOrderItemList(result.orders);
	});
});

/* 주문 정보 출력 함수 */
function printOrderInfo(orderInfo) {
	let date = new Date(orderInfo.orderDate);
	let date_string = date.getFullYear() + "/" + (date.getMonth() + 1) + "/" + date.getDate();
	
	$(".modal_addressee").text(orderInfo.addressee);
	$(".modal_memberAddr").text("(" + orderInfo.memberAddr1 + ")" + orderInfo.memberAddr2 + " " + orderInfo.memberAddr3);
	$(".modal_orderDate").text(date_string);
	$(".modal_deliveryCost").text(orderInfo.deliveryCost.toLocaleString() + "원");
	$(".modal_usePoint").text(orderInfo.usePoint.toLocaleString() + "p");
	$(".modal_orderSalePrice").text(orderInfo.orderSalePrice.toLocaleString() + "원");
	$(".modal_orderSavePoint").text(orderInfo.orderSavePoint.toLocaleString() + "p");
	$(".modal_orderState").text(orderInfo.orderState);
}

/* 주문 아이템 리스트 출력 함수 */
function printOrderItemList(list){
	$(".orderItemList").html("");
	
	$(list).each(function(index, obj){
		let content = "";
		content += "<tr>";
		content += "<td><img width='70px' src='" + obj.bookImage + "'></td>";
		content += "<td>" + obj.bookName + "</td>";
		content += "<td>" + obj.bookCount + "</td>";
		content += "<td>" + obj.totalPrice.toLocaleString() + "</td>";
		
		$(".orderItemList").append(content);
	});
}
</script>
</html>