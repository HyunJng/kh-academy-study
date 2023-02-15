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
			<jsp:include page="/WEB-INF/views/fix/admin_menu.jsp"></jsp:include>
			<div class="col-10">
				<div id="admin_subtitle" class="py-2 ps-2">
					<h4>상품 관리</h4>
				</div>
				<form id="search_form" action="/admin/manageGoods" class="py-2 row">
					<div class="col-2">
						<select name="type" class="form-select">
							<option value="" class="">선택</option>
							<option value="T" >제목</option>
							<option value="A" >작가</option>
							<option value="P" >출판사</option>
						</select>
					</div>
					<div class="col-5 m-0">
						<input class="form-control" type="text" name="keyword" placeholder="검색어입력">
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
	
	$("#search_form button[type='submit']").click(function(e){
		var type = $("#search_form select").val();
		var keyword = $("#search_form input[name='keyword']").val();
		
		if(!type){
			alert("검색 종류를 선택하세요.");
			return false;
		}
		if(!keyword){
			alert("검색어를 입력하세요.");
			return false;
		}
		
		return true;
	});
</script>
</html>