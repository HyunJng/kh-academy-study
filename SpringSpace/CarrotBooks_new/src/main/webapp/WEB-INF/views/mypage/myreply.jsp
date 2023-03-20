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
<style type="text/css">
.empty_div {
	padding-top: 80px;
	width: 100%;
	height: 300px;
}
.empty_div h5 {
	text-align: center;
	margin: auto;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/fix/gnb.jsp"></jsp:include>
	
	<div class="container">
		<header>
			<jsp:include page="/WEB-INF/views/fix/header.jsp"></jsp:include>
		</header>
		<div class="page_sub_header mt-2">
			<h4>#마이페이지</h4>
		</div>
		<div class="row mt-2">
			<div class="col-3">
				<jsp:include page="/WEB-INF/views/fix/mypage_menu.jsp"></jsp:include>
			</div>
			<div class="col-9">
				<h5>#내 댓글</h5>
				<c:if test="${replyChk == 'empty'}">
					<div class="empty_div">
						<h5>아직 작성한 댓글이 없습니다</h5>
					</div>
				</c:if>
				<c:if test="${replyChk != 'empty'}">
					<table class="table">
						<thead>
							<tr>
								<th width="35%">책이름</th>
								<th width="40%">댓글내용</th>
								<th width="15%">별점</th>
								<th width="10%"></th>
							</tr>
						</thead>
						<tbody class="reply_tbody reply_tbody">
							<c:forEach var="obj" items="${reply.replyList}">
								<tr>
									<td><a href='/product/detail/${obj.bookId }'>${obj.bookName}</a></td> 
									<td>${obj.content}</td> 
									<td>${obj.rating}</td> 
									<td><button class='btn btn-sm btn-light replyDelete_btn' data-replyid='${obj.replyId}' data-bookid='${obj.bookId}'>X</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<ul class="pagination d-flex justify-content-center">
						<c:if test="${reply.pageInfo.prev}">
							<li class="page-item"><a class="page-link reply-page-btn" href="${reply.pageInfo.startPage-1}">Previous</a></li>
						</c:if>
						<c:forEach var="num" begin="${reply.pageInfo.startPage}" end="${reply.pageInfo.endPage}">
							<li class="page-item ${reply.pageInfo.cri.pageNum == num ? 'active':'' }">
								<a class="page-link reply-page-btn" href="${num}">${num}</a></li>
						</c:forEach>
						<c:if test="${reply.pageInfo.next }">
							<li class="page-item"><a class="page-link reply-page-btn" href="${reply.pageInfo.endPage+1}">Next</a></li>
						</c:if>
					</ul>
				</c:if>
			</div>
		</div>
	</div>
	
	<footer>
		<jsp:include page="/WEB-INF/views/fix/footer.jsp"></jsp:include>
	</footer>
</body>
<script type="text/javascript">
/* 댓글 삭제 버튼 눌렀을 때 */
$(document).on("click",".replyDelete_btn", function(e){
	e.preventDefault();
	let replyId = $(this).data("replyid");
	let bookId = $(this).data("bookid");
	let keyword = "${member.memberId}";
	
	$.getJSON("/admin/manageMember/reply/delete", {"keyword" : keyword, "replyId": replyId, "bookId" : bookId}, function(obj){
		printReplyList(obj);
	});
});

/* 댓글 페이지 버튼 눌렀을 떄 */
$(document).on("click",".reply-page-btn", function(e){
	e.preventDefault();
	let pageNum = $(this).attr("href");
	let keyword = "${member.memberId}";
	
	$.getJSON("/mypage/getreply", {"keyword" : keyword, "pageNum": pageNum}, function(obj){
		printReplyList(obj);
	});
});

/* 댓글 리스트 출력 메서드 */
function printReplyList(obj){
	let list = obj.replyList;
	let pageMaker = obj.pageInfo;
	
	$(".reply_tbody").html("");
	$('.pagination').html("");
	
	// 댓글
	$(list).each(function(index, obj){
		let content = "";
		content += "<tr>";
		content += "<td><a href='/product/detail/"+obj.bookId+"'>" + obj.bookName + "</a></td>" 
		content += "<td>" + obj.content + "</td>" 
		content += "<td>" + obj.rating + "</td>" 
		content += "<td><button class='btn btn-sm btn-light replyDelete_btn' data-replyid='"+ obj.replyId+"' data-bookid='"+obj.bookId+"'>X</button></td>" 
		content += "</tr>";
		
		$(".reply_tbody").append(content);
	});
	
	// 댓글 페이징
	let pageMaker_html = "";
	
	if(pageMaker.prev){
		let prev_num = pageMaker.startPage - 1; 
		pageMaker_html += '<li class="pageMaker_btn prev page-item">';
		pageMaker_html += '<a class="page-link reply-page-btn" href="'+ prev_num+'">이전</a>'
		pageMaker_html += '</li>';
	}
	
	for(let i = pageMaker.startPage; i < pageMaker.endPage + 1; i++){
		pageMaker_html += '<li class="page-item ';
		if(pageMaker.cri.pageNum === i){
			pageMaker_html += 'active';
		}
		pageMaker_html += '">';
		pageMaker_html += '<a class="page-link reply-page-btn" href="'+ i +'">' + i + '</a>';
		pageMaker_html += '</li>';
	}
	
	if(pageMaker.next){
		let next_num = pageMaker.endPage + 1; 
		pageMaker_html += '<li class="pageMaker_btn next page-item">';
		pageMaker_html += '<a class="page-link reply-page-btn" href="'+ next_num+'">이후</a>'
		pageMaker_html += '</li>';
	}
	
	$('.pagination').append(pageMaker_html);
}
</script>
</html>