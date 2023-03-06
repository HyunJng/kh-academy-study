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
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
</head>
<body>
	
	<!-- gnd -->
	<jsp:include page="/WEB-INF/views/fix/gnb.jsp"></jsp:include>

	<div class="container">
		<div id="admin_title"class="pt-4 pb-4 ps-3">
			<h1>관리자페이지</h1>
		</div>
		<div class="row mt-2">
			<jsp:include page="/WEB-INF/views/fix/admin_menu.jsp"></jsp:include>
			<div class="col-10">
				<div id="admin_subtitle" class="py-2 ps-2">
					<h4>주문 관리</h4>
				</div>

				<form id="search_form" action="/admin/orderList" class="py-2 row">
					<div class="col-2">
						<select name="type" class="form-select">
							<option  selected>회원이메일</option>
						</select>
					</div>
					<div class="col-5 m-0">
						<input class="form-control" type="text" name="keyword" placeholder="검색어입력">
					</div>
					<button class="btn btn-secondary ms-1 col-2  px-1" type="submit">검색</button>
				</form>
				
				<table class="table">
					<colgroup>
	                    <col width="21%">
	                    <col width="*%">
	                    <col width="15%">
	                    <col width="20%">
	                    <col width="10%">
	                    <col width="10%">
					</colgroup>
					<thead class="table-success">
						<tr>
							<th>주문ID</th>
							<th>회원이메일</th>
							<th>주문상태</th>
							<th>주문일</th>
							<th>취소</th>
							<th>주문상세</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="listCheck != 'empty'">
							없음
						</c:if>
						<c:forEach var="order" items="${orderList}">
							<tr>
								<td>${order.orderId}</td>
								<td>${order.memberEmail}</td>
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
								<td><button class="btn btn-sm btn-secondary">click</button></td>
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
				
			</div>
		</div>
		<div>
			<!-- 주문 취소 form -->
			<form id="deleteForm" action="/admin/orderCancle" method="post">
				<input type="hidden" name="orderId">			
				<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
				<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
				<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
				<input type="hidden" name="memberId" value="${member.memberId}">			
			</form>
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
	$("#pageForm").attr("action", "/admin/orderList");
	$("#pageForm").submit();
});
</script>
</html>