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
					<h4>상품 등록 폼</h4>
				</div>
				<form class="mt-3" action="#" method="post">
					<input type="hidden" name="bookId" value="${book.bookId}">
					<div class="d-flex justify-content-center">
						<input type="hidden" name="image" value="${book.image}">
						<img alt="책 표지" src="${book.image}">
					</div>
					<div class="row ps-2">
						<label class="form-label col-2">제목</label>
						<div class="col-10">
							<input class="form-control" type="text" name="title" value="${book.title}" readonly>
						</div>
					</div>
					<div class="row ps-2">
						<label class="form-label col-2">작가</label>
						<div class="col-10">
							<input class="form-control" type="text" name="author" value="${book.author}" readonly>
						</div>
					</div>
					<div class="row ps-2">
						<label class="form-label col-2">출판사</label>
						<div class="col-10">
							<input class="form-control" type="text" name="publisher" value="${book.publisher}" readonly>
						</div>
					</div>
					<div class="row ps-2">
						<label class="form-label col-2">정가</label>
						<div class="col-10">
							<input class="form-control" type="text" name="fullPrice" value="${book.fullPrice}" readonly>
						</div>
					</div>
					<div class="row ps-2">
						<label class="form-label col-2 text-danger">판매가</label>
						<div class="col-10">
							<input class="form-control" type="text" name="salePrice" required>
						</div>
					</div>
					<div class="row ps-2">
						<label class="form-label col-2 text-danger">수량</label>
						<div class="col-10">
							<input class="form-control" type="number" name="amount" value="1" min="1" max="50" required>
						</div>
					</div>
					<div class="row ps-2">
						<label class="form-label col-2">요약</label>
						<div class="col-10">
							<textarea id="book_content"class="form-control" name="contents" readonly>${book.contents}</textarea>
						</div>
					</div>
					<div class="d-flex justify-content-end mt-3">
						<button class="btn btn-secondary" type="submit">등록하기</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/fix/footer.jsp"></jsp:include>
	</footer>
</body>
</html>