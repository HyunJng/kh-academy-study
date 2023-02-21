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
							<div>
								<span class="cate_span">대분류</span>
								<select id="cate1" class="form-select cate_select">
									<option value="none" selected>선택</option>
								</select>
							</div>
							<div>
								<span class="cate_span">중분류</span>
								<select id="cate2" class="form-select cate_select">
									<option value="none" selected>선택</option>
								</select>
							</div>
							<div>
								<span class="cate_span">소분류</span>
								<select id="cate3" class="form-select cate_select" name="bookCate">
									<option value="none" selected>선택</option>
								</select>
							</div>
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

<script type="text/javascript">
/* 카테고리 */
let cateList = JSON.parse('${cateList}');

// 카테고리 분류해서 넣을 배열
let cate1Arr = new Array();
let cate2Arr = new Array();
let cate3Arr = new Array();

// 출력용
let cateSelect1 = $("#cate1");
let cateSelect2 = $("#cate2");
let cateSelect3 = $("#cate3");

// 분류과정
makeCateArr(cate1Arr, cateList, 1);
makeCateArr(cate2Arr, cateList, 2);
makeCateArr(cate3Arr, cateList, 3);

function makeCateArr(arr, cateList, tier){
	for(let i = 0; i<cateList.length; i++){
		if(cateList[i].tier === tier){
			let obj = new Object();
			
			obj.cateName = cateList[i].cateName;
			obj.cateCode = cateList[i].cateCode;
			obj.cateParent = cateList[i].cateParent;
			
			arr.push(obj);
		}
	}
}

// 중분류 option 출력
$(cateSelect1).on("change", function(){
	let selectVal1 = $(this).find("option:selected").val();
	
	cateSelect2.children().remove();
	cateSelect2.append("<option value='none'>선택</option>")
	cateSelect3.children().remove();
	cateSelect3.append("<option value='none'>선택</option>")
	
	for(let i = 0; i < cate2Arr.length; i++){
		if(selectVal1 === cate2Arr[i].cateParent) {
			cateSelect2.append("<option value='" + cate2Arr[i].cateCode +"'>" + cate2Arr[i].cateName + "</option>");
		}
	}
});

// 소분류 option 출력
$(cateSelect2).on("change", function(){
	let selectVal2 = $(this).find("option:selected").val();
	cateSelect3.children().remove();
	cateSelect3.append("<option value='none'>선택</option>")

	for(let i = 0; i < cate3Arr.length; i++){
		if(selectVal2 === cate3Arr[i].cateParent) {
			cateSelect3.append("<option value='" + cate3Arr[i].cateCode +"'>" + cate3Arr[i].cateName + "</option>");
		}
	}
});

$(function(){
	// 대분류 option 출력
	for(let i = 0; i < cate1Arr.length; i++){
		cateSelect1.append("<option value='"+cate1Arr[i].cateCode+"'>" + cate1Arr[i].cateName + "</option>");
	}
})
</script>
</html>