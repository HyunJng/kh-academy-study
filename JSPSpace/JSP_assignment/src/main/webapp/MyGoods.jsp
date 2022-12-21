<%@page import="article.articleDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
		crossorigin="anonymous">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="http://code.jquery.com/jquery-3.1.1.js"></script>

	<div class="col-lg-8">


		<!-- Nested row for non-featured blog posts-->
		<div class="row">
	
			<!-- Blog post-->
			<c:forEach items="${MboardList }" var="board">
				<div class="card mb-4" style = "text-align: center;">
					<img class="card-img-top" src="upload/${board.goods_img }"
						alt="..." />
					<div class="card-body">
						<div class="small text-muted">구매일자 ${board.reg_date }</div>
						<h2 class="card-title h4">${board.goods }</h2>
						<p class="card-text">${board.goods_info }</p>
						<p class="card-text">${board.count }개 구입</p>
						<p class="card-text">${board.count *board. cost}원</p>
						
						<input name="seq" type="hidden" value="${board.seq }">
						<button class="btn btn-primary"
							onclick="window.open('getBoard.do?seq=${board.seq}', 'test', 'width=700px,height=800px,scrollbars=yes');">자세히
							보기</button>
							<button class="btn btn-primary"
							onclick="location.href='deleteMygoods.do?seq=${board.seq}'">배송 완료</button>
					</div>
				</div>
			</c:forEach>


		</div>
		<!-- Pagination-->
		<nav aria-label="Pagination">
			<hr class="my-0" />
			<ul class="pagination justify-content-center my-4">
				<c:if test="${MstartPage>MpageBlock }">
					<li class="page-item disabled"><a class="page-link"
						href="getUserInfo.do?pageNum=${MstartPage-10 }" tabindex="-1"
						aria-disabled="true">Newer</a></li>
				</c:if>
			

				<c:forEach var="num" begin="${MstartPage+1 }" end="${MendPage}">
					<c:choose>
						
						<c:when test="${num == McurrentPage}">
						
		<li class="page-item active" aria-current="page"><a
						class="page-link">${num }</a></li>
	</c:when>
						
						<c:otherwise>
							
		<li class="page-item"><a class="page-link"
						href="getUserInfo.do?pageNum=${num }">${num }</a></li>
	</c:otherwise>
						
					</c:choose>
					
				
								</c:forEach>
				<c:if test="${MendPage< MpageCount}">
				<li class="page-item"><a class="page-link"
					href="getUserInfo.do?pageNum=${MstartPage+10 }">Older</a></li>
				</c:if>
			
			</ul>
		</nav>
	</div>
	
	
</body>
<script type="text/javascript">

		$(document).on("click","button[id='btn']",function() {
			
			var url = 'getBoard.do?seq=' + $('input[name=seq]').val();
			
			
		
	});
		
		</script>
</html>