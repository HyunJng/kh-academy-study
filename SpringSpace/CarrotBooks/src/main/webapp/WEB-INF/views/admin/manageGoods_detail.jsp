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
					<h4>상품 세부사항</h4>
				</div>
				<form class="mt-3" action="/admin/manageGoods/update" method="post">
					<input type="hidden" name="bookId" value="${book.bookId}">
					<div class="d-flex justify-content-center">
						<input type="hidden" name="bookImage" value="${book.bookImage}">
						<img alt="책 표지" src="${book.bookImage}">
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
						<label class="form-label col-2 text-danger">카테고리</label>
						<div class="col-10">
							<select class="form-select" name="bookCate">
								<option value="NOVEL">소설</option>
								<option value="HUMAN" >인문</option>
								<option value="SCIENCE">과학</option>
								<option value="PHILOSOPHY">철학</option>
							</select>
						</div>
					</div>
					<div class="row ps-2">
						<label class="form-label col-2 text-danger">할인률</label>
						<div class="col-10">
							<input class="form-control" type="number" name="discountPer" value="${book.discountPer}" min="0" max="100" required>
						</div>
					</div>
					<div class="row ps-2">
						<label class="form-label col-2 text-danger">수량</label>
						<div class="col-10">
							<input class="form-control" type="number" name="bookStock" value="${book.bookStock}" min="0" max="50" required>
						</div>
					</div>
					<div class="row ps-2">
						<label class="form-label col-2">책소개</label>
						<div class="col-10">
							<textarea id="bookIntro"class="form-control" name="bookIntro" readonly>${book.bookIntro}</textarea>
						</div>
					</div>
					<div class="d-flex justify-content-end mt-3">
						<button class="btn btn-light mx-1" type="button" onclick="location.href='/admin/manageGoods'">돌아가기</button>
						<button class="btn btn-secondary" type="submit">수정하기</button>
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