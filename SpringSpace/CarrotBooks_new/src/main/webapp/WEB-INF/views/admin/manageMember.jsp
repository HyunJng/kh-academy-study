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
<style type="text/css">
	a {
		cursor: pointer;
	}
</style>
</head>
<body>
	<!-- gnd -->
	<jsp:include page="/WEB-INF/views/fix/gnb_admin.jsp"></jsp:include>

	<div class="container">
		<div id="admin_title"class="pt-4 pb-4 ps-3">
			<h1>관리자페이지</h1>
		</div>
		<div class="row mt-2">
			<jsp:include page="/WEB-INF/views/fix/admin_menu.jsp"></jsp:include>
			<div class="col-10">
				<div id="admin_subtitle" class="py-2 ps-2">
					<h4>회원 관리</h4>
				</div>
				
				<!-- 회원 검색  -->
				<form id="search_form" action="/admin/manageMember" class="py-2 row">
					<div class="col-2">
						<select name="type" class="form-select">
							<option value="" class="">선택</option>
							<option value="E" >이메일</option>
							<option value="N" >회원이름</option>
							<option value="C" >구분</option>
						</select>
					</div>
					<div class="col-5 m-0">
						<input class="form-control" type="text" name="keyword" placeholder="검색어입력">
					</div>
					<button class="btn btn-secondary ms-1 col-2  px-1" type="submit">검색</button>
				</form>
				
				<!-- 회원 목록 -->
				<table class="table">
					<colgroup>
						<col width="10%" />
						<col width="25%" />
						<col width="15%" />
						<col width="10%" />
						<col width="15%" />
						<col width="15%" />
						<col width="10%" />
					</colgroup>
					<thead class="table-success">
						<tr>
							<th>#</th>
							<th>이메일</th>
							<th>회원이름</th>
							<th>구분</th>
							<th>포인트</th>
							<th>가입일</th>
							<th>가입방법</th>
							<th>BAN</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="member" items="${memberList}">
							<tr>
								<td>${member.memberId}</td>
								<td><a class="memberDetail" data-memberid="${member.memberId}" data-bs-toggle="modal" data-bs-target="#memberDetail">${member.memberEmail}</a></td>
								<td>${member.memberName}</td>
								<td>${member.memberCk}</td>
								<td>${member.memberPoint}</td>
								<td>${member.regDate}</td>
								<td>${member.loginType}</td>
								<td>
									<a href="/admin/manageMember/ban/${member.memberId}">
										<c:if test="${member.memberCk == 'USER'}">
											<span class="badge bg-danger" >X</span>
										</c:if>
										<c:if test="${member.memberCk == 'BAN'}">
											<span class="badge bg-success" >O</span>
										</c:if>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<!-- 회원 상세 모달창  -->
				<div class="modal fade" id="memberDetail">
				  <div class="modal-dialog">
				    <div class="modal-content">
				
				      <!-- 모달 Header-->
				      <div class="modal-header">
				        <h4 class="modal-title">회원상세정보</h4>
				        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				      </div>
				
				      <!-- 모달 body -->
				      <div class="modal-body">
				        <table class="table border border-secondary">
				        	<tr>
				        		<th width="30%">회원번호</th>
				        		<td width="70%" class="modal_memberId">22</td>
				        	</tr>
				        	<tr>
				        		<th>회원이메일</th>
				        		<td class="modal_memberEmail">kkkk@naver.com</td>
				        	</tr>
				        	<tr>
				        		<th>회원 이름</th>
				        		<td class="modal_memberName">홍길동</td>
				        	</tr>
				        	<tr>
				        		<th>회원 주소</th>
				        		<td class="modal_memberAddr">~~~</td>
				        	</tr>
				        	<tr>
				        		<th>회원타입</th>
				        		<td class="modal_memberCk">ADMIN</td>
				        	</tr>
				        	<tr>
				        		<th>포인트</th>
				        		<td class="modal_memberPoint">1000p</td>
				        	</tr>
				        	<tr>
				        		<th>등록일</th>
				        		<td class="modal_regDate">23/11/5</td>
				        	</tr>
				        	<tr>
				        		<th>로그인타입</th>
				        		<td class="modal_loginType">GENERAL</td>
				        	</tr>
				        </table>
				        <hr class="mt-4">
				        <h5 class="mt-4"># 댓글 목록</h5>
				       	<table class="table">
				       		<thead>
				       			<tr>
				       				<th width="35%">책이름</th>
				       				<th width="40%">댓글내용</th>
				       				<th width="15%">별점</th>
				       				<th width="10%"></th>
				       			</tr>
				       		</thead>
				       		<tbody class="reply_tbody">
				       		</tbody>
				       	</table>
				       	<ul class="pageMaker pagination d-flex justify-content-center"></ul>
				      </div>
				
				      <!-- 모달 footer -->
				      <div class="modal-footer">
				        <button class="btn btn-danger deleteMember_btn">회원강퇴</button>
				      </div>
				
				    </div>
				  </div>
				</div>
				
				
				<!-- 회원 목록 페이지 -->
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
		
		<!-- 회원 삭제 form -->
		<form action="/admin/manageMember/delete" id="deleteMember_form" method="post">
			<input type="hidden" name="memberId">
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
		</form>
	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/fix/footer.jsp"></jsp:include>
	</footer>
</body>
<script type="text/javascript">
	/* 회원 상세 모달 */
	$(".memberDetail").on("click", function(e){
		e.preventDefault();
		let memberId = $(this).data("memberid");
		$.getJSON('/admin/manageMember/' + memberId,function(result){
			
			// 회원 상세정보 출력
			printMemberInfo(result.member);
			printReplyList(result.reply);
		});
	});
	/* 회원 강퇴 버튼 */
	$(".deleteMember_btn").on("click", function(e){
		e.preventDefault();
		let memberId = $(".modal_memberId").text();
		$("#deleteMember_form").find("input[name='memberId']").val(memberId);
		$("#deleteMember_form").submit();
	});
	
	/* 멤버 상세 정보 출력 메서드 */
	function printMemberInfo(member){
		let date = new Date(member.regDate);
		let date_string = date.getFullYear() + "/" + (date.getMonth() + 1) + "/" + date.getDate();
		
		$(".modal_memberId").text(member.memberId);
		$(".modal_memberEmail").text(member.memberEmail);
		$(".modal_memberName").text(member.memberName);
		$(".modal_memberAddr").text("(" + member.memberAddr1 + ")" + member.memberAddr2 + " " + member.memberAddr3);
		$(".modal_memberCk").text(member.memberCk);
		$(".modal_memberPoint").text(member.memberPoint.toLocaleString() + "p");
		$(".modal_regDate").text(date_string);
	}
	
	/* 댓글 삭제 버튼 눌렀을 때 */
	$(document).on("click",".replyDelete_btn", function(e){
		e.preventDefault();
		let replyId = $(this).data("replyid");
		let bookId = $(this).data("bookid");
		let keyword = $(".modal_memberId").text();

		$.getJSON("/admin/manageMember/reply/delete", {"keyword" : keyword, "replyId": replyId, "bookId" : bookId}, function(obj){
			printReplyList(obj);
		});
	});
	
	/* 댓글 페이지 버튼 눌렀을 떄 */
	$(document).on("click",".reply-page-btn", function(e){
		e.preventDefault();
		let pageNum = $(this).attr("href");
		let keyword = $(".modal_memberId").text();
	
		$.getJSON("/admin/manageMember/reply", {"keyword" : keyword, "pageNum": pageNum}, function(obj){
			printReplyList(obj);
		});
 	});
	
	/* 댓글 리스트 출력 메서드 */
	function printReplyList(obj){
		let list = obj.replyList;
		let pageMaker = obj.pageInfo;
		
		$(".reply_tbody").html("");
		$('.pageMaker').html("");
		
		// 댓글
		$(list).each(function(index, obj){
			let content = "";
			content += "<tr>";
			content += "<td>" + obj.bookName + "</td>" 
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
		
		$('.pageMaker').append(pageMaker_html);
	}
	
	/* 회원목록 페이징 처리 */
	$("#pageForm a").click(function(e) {
		e.preventDefault();
		$("#pageForm").find("input[name='pageNum']").val($(this).attr("href"));
		$("#pageForm").attr("action", "/admin/manageGoods");
		$("#pageForm").submit();
	});

	/* 검색 처리 */
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
</script>
</html>