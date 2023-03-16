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
</head>
<body>
	<jsp:include page="/WEB-INF/views/fix/gnb.jsp"></jsp:include>
	
	<div class="container">
		<header>
			<jsp:include page="/WEB-INF/views/fix/header.jsp"></jsp:include>
		</header>
		<div class="page_sub_header mt-2">
			<h4>#회원님들의 추천 목록</h4>
		</div>
		<div>
		<c:if test="${bookListChk != 'empty'}">
			<table class="table">
				<colgroup>
					<col width="18%">
					<col width="35%">
					<col width="15%">
					<col width="14%">
					<col width="18%">
				</colgroup>
				<tbody>
					<c:forEach var="book" items="${bestList}">
						<tr class="pt-2">
							<td>
								<a href="/product/detail/${book.bookId}">
									<img alt="이미지" src="${book.bookImage}">
								</a>
							</td>
							<td>
								<div class="mt-2">
									[${book.bookCateName }]
									<a href="/product/detail/${book.bookId}">${book.title }</a>
								</div>
								<div class="mt-1">
									${book.author} 지음 | '${book.publisher }' 출판사
								</div>
							</td>
							<td>
								<div class="mt-2">
									<h6>평점: ${book.ratingAvg}</h6> 
									<span class="rating_star"><c:forEach begin="1" end="${Math.round(book.ratingAvg)}">★</c:forEach><c:forEach begin="1" end="${5 - Math.round(book.ratingAvg)}">☆</c:forEach></span>
								</div>
							</td>
							<td>
								<div class="mt-1">
									<del>
										<fmt:formatNumber value="${book.fullPrice}" pattern="##,### 원" />
									</del>
								</div>
								<div>
									<strong>
										<fmt:formatNumber value="${book.fullPrice * (1 - book.discountPer/100)}" pattern="##,### 원" />
									</strong>
								</div>
							</td>
							<td>
								<div class="d-grid gap-2 mt-2">
									<button class="btn btn-secondary btn-block addCart_btn" data-bookid="${book.bookId}">장바구니 담기</button>
									<button class="btn btn-light btn-block order_btn" data-bookid="${book.bookId}">바로 구매</button>
								</div>
							</td>
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
		<c:if test="${bestListChk == 'empty'}">
			<div class="table_empty d-flex justify-content-center">
				<h5>검색 결과가 없습니다</h5>
			</div>
		</c:if>
		</div>
		
		<!-- 바로 주문 form  -->
		<form action="/order/${member.memberId}" method="get" class="order_form">
			<input type="hidden" name="orders[0].bookId">
			<input type="hidden" name="orders[0].bookCount" value="1">
		</form>
	</div>
	
	<footer>
		<jsp:include page="/WEB-INF/views/fix/footer.jsp"></jsp:include>
	</footer>
</body>
<script type="text/javascript">
$(function(){
	/* 검색 키워드 출력 */
	let keyword = "${pageMaker.cri.keyword}";
	if(keyword != ""){
		$("input[name='keyword']").val("${pageMaker.cri.keyword}");
		$("select[name='type']").val("${pageMaker.cri.type}").attr("selected", "selected");
	}
})
/* 페이징 처리 */
$("#pageForm a").click(function(e) {
	e.preventDefault();
	$("#pageForm").find("input[name='pageNum']").val($(this).attr("href"));
	$("#pageForm").attr("action", "/best");
	$("#pageForm").submit();
});

/* 바로주문 클릭 */
$(".order_btn").on("click", function(){
	let member = '${member}';
	let bookid = $(this).data("bookid");
	
	if(member === ""){ 
		alert("로그인이 필요합니다.");
		location.href="/member/login";
		return;
	}
	
	$(".order_form").find("input[name='orders[0].bookId']").val(bookid);
	$(".order_form").submit();
});

/* 장바구니 추가 */
const form = {
		bookId : '',
		bookCount: '1',
		memberId : '${member.memberId}'
}

// 장바구니 버튼 클릭
$('.addCart_btn').on("click", function(e){
	form.bookId = $(this).data("bookid");
	
	// post로 int값을 공백 넣어주면 에러가 발생하므로 임의의 값 넣기
	if(form.memberId === ""){
		form.memberId = 0;
	}

	$.ajax({
		url: '/cart/add',
		type: 'POST',
		data: form,
		success: function(result){
			if(result == "0"){
				alert("장바구니에 추가를 하지 못하였습니다.");
			} else if(result == "1"){
				alert("장바구니에 추가되었습니다.");
			} else if(result == "2"){
				alert("장바구니에 이미 존재합니다.");
			} else if(result == "5"){
				alert("로그인이 필요합니다.");
				location.href="/member/login";
			}
		}
	});
});
</script>
</html>