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
		<h1 class="card-title h4">${sum }</h2>
		${user.role }

		<!-- Nested row for non-featured blog posts-->
		<div class="row">
		
			<!-- Blog post-->
			<c:forEach items="${SboardList }" var="board">
				<div class="card mb-4" style = "text-align: center;">
					<img class="card-img-top" src="upload/${board.goods_img }"
						alt="..." />
					<div class="card-body">
						<div class="small text-muted">상품 등록일 ${board.reg_date }</div>
						<h2 class="card-title h4">${board.goods }</h2>
						<p class="card-text">${board.goods_info }</p>
						<p class="card-text">${board. cost}원</p>
						<p class="card-text">${board. sell_count}개 판매</p>
						<p class="card-text">${board. cost * board. sell_count}원 판매</p>
						<c:choose>
						<c:when test="${board.count>0 }">
						<p class="card-text">물품 잔량 ${board. count} 개</p>
						</c:when>
						<c:otherwise>
							<p class="card-text">품절입니다</p>
						</c:otherwise>
						</c:choose>
						<input name="seq" type="hidden" value="${board.seq }">
						<button class="btn btn-primary"
							onclick="location.href='getBoardUpdate.do?seq=${board.seq}'">업데이트 하기</button>
							<button class="btn btn-primary"
							onclick="location.href='getBoardDelete.do?seq=${board.seq}'">제품 삭제하기</button>
						
					</div>
				</div>
			</c:forEach>


		</div>
		<!-- Pagination-->
		<nav aria-label="Pagination">
			<hr class="my-0" />
			<ul class="pagination justify-content-center my-4">
				<c:if test="${SstartPage>SpageBlock }">
					<li class="page-item disabled"><a class="page-link"
						href="getUserInfo.do?pageNum=${SstartPage-10 }" tabindex="-1"
						aria-disabled="true">Newer</a></li>
				</c:if>
			

				<c:forEach var="num" begin="${SstartPage }" end="${SendPage}">
					<c:choose>
						
						<c:when test="${num == ScurrentPage}">
						
		<li class="page-item active" aria-current="page"><a
						class="page-link">${num }</a></li>
	</c:when>
						
						<c:otherwise>
							
		<li class="page-item"><a class="page-link"
						href="getUserInfo.do?pageNum=${num }">${num }</a></li>
	</c:otherwise>
						
					</c:choose>
					
				
								</c:forEach>
				<c:if test="${SendPage< SpageCount}">
				<li class="page-item"><a class="page-link"
					href="getUserInfo.do?pageNum=${SstartPage+10 }">Older</a></li>
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