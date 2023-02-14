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
					<h4>상품 관리</h4>
				</div>
				<form action="#" class="py-2 row">
					<div class="col-7 m-0">
						<input class="col-3 form-control" type="text" placeholder="제목검색">
					</div>
					<button class="btn btn-secondary ms-1 col-2  px-1" type="submit">검색</button>
					<button class="btn btn-light ms-3 col-2" type="button" onclick="location.href='/admin/addGoods'">상품등록</button>
				</form>
				
				<table class="table">
					<thead class="table-success">
						<tr>
							<th>#</th>
							<th>책 제목</th>
							<th>작가</th>
							<th>출판사</th>
							<th>수량</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${bookList}">
							<tr>
								<td></td>
								<td>${book.title}</td>
								<td>${book.author}</td>
								<td>${book.publisher}</td>
								<td>${book.bookStock}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<form id="pageForm" method="get">
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
	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/fix/footer.jsp"></jsp:include>
	</footer>
</body>
<script type="text/javascript">
	$("#pageForm a").click(function(e){
		e.preventDefault();
		$("#pageForm").find("input[name='pageNum']").val($(this).attr("href"));
		$("#pageForm").attr("action", "/admin/manageGoods");
		$("#pageForm").submit();
	});
</script>
</html>