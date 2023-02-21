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
<style type="text/css">
	.table_empty {
		width : 100%;
		height: 300px;
	}
	.table_empty h5 {
		margin: auto;
	}

</style>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/fix/gnb.jsp"></jsp:include>
	
	<div class="container">
		<header>
			<jsp:include page="/WEB-INF/views/fix/header.jsp"></jsp:include>
		</header>
		<div>
		<c:if test="${bookListChk != 'empty'}">
			<table class="table">
				<colgroup>
					<col width="18%">
					<col width="45%">
					<col width="10%">
					<col width="14%">
					<col width="13%">
				</colgroup>
				<tbody>
					<c:forEach var="book" items="${bookList}">
						<tr class="pt-2">
							<td>
								<img alt="이미지" src="${book.bookImage}">
							</td>
							<td>
								<div class="mt-2">
									[${book.bookCateName }]
									${book.title }
								</div>
								<div class="mt-1">
									${book.author} 지음 | '${book.publisher }' 출판사
								</div>
							</td>
							<td>
								<div>
									평점
								</div>
							</td>
							<td>
								<div>
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
								추후추가
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
		<c:if test="${bookListChk == 'empty'}">
			<div class="table_empty d-flex justify-content-center">
				<h5>검색 결과가 없습니다</h5>
			</div>
		</c:if>
		</div>
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
	$("#pageForm").attr("action", "/main/search");
	$("#pageForm").submit();
});
</script>
</html>