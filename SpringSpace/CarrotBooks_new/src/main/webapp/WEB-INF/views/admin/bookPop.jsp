<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div class="container">
		<div class="px-2 py-3 bg-light">
			<h3>책 선택</h3>
		</div>
		<div>
			<c:if test="${listCheck != 'empty'}">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>제목</th>
							<th>작가</th>
							<th>출판사</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${list}">
							<tr>
								<td>${book.bookId}</td>
								<td><a class="move" href="${book.bookId}" data-name="${book.title}">${book.title}</a></td>
								<td>${book.author}</td>
								<td>${book.publisher}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${listCheck =='empty' }">
				<div>
					등록된 책이 없습니다.
				</div>
			</c:if>
			
			<!-- 검색 -->
			<div class="d-flex justify-content-center">
				<form action="/admin/bookPop" method="get">
					<div class="row">
						<div class="col-4">
							<select name="type" class="form-select">
								<option value="" class="">선택</option>
								<option value="T" >제목</option>
								<option value="A" >작가</option>
								<option value="P" >출판사</option>
							</select>
						</div>
						<div class="col-6 m-0">
							<input class="form-control" type="text" name="keyword" placeholder="검색어입력">
						</div>
						<button class="btn btn-secondary col-2  px-1" type="submit">검색</button>
					</div>
				</form>
			</div>
			<!-- 페이지 이동 -->
			<div>
				<form class="d-flex justify-content-center my-2" id="pageForm" method="get">
					<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li class="page-item"><a class="page-link" href="${pageMaker.startPage-1}">&lt;</a></li>
						</c:if>
						<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							<li class="page-item ${pageMaker.cri.pageNum == num ? 'active':'' }"><a class="page-link" href="${num}" >${num}</a></li>
						</c:forEach>
						<c:if test="${pageMaker.next }">
							<li class="page-item"><a class="page-link" href="${pageMaker.endPage+1}">&gt;</a></li>
						</c:if>
					</ul>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
$("#pageForm a").click(function(e) {
	e.preventDefault();
	$("#pageForm").find("input[name='pageNum']").val($(this).attr("href"));
	$("#pageForm").attr("action", "/admin/bookPop");
	$("#pageForm").submit();
});

$("#search_form button[type='submit']").click(function(e) {
	var type = $("#search_form select").val();
	var keyword = $("#search_form input[name='keyword']").val();

	if (!type) {
		alert("검색 종류를 선택하세요.");
		return false;
	}
	if (!keyword) {
		alert("검색어를 입력하세요.");
		return false;
	}

	return true;
});

$(".move").on("click", function(e){
	e.preventDefault();
	
	let bookId = $(this).attr("href");
	let bookName = $(this).data("name");
	$(opener.document).find("#bookId_input").val(bookId);
	$(opener.document).find("#bookName_input").val(bookName);
	
	window.close();
});

</script>
</html>