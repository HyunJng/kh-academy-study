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
					<h4>회원 관리</h4>
				</div>
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
				
				<table class="table">
					<colgroup>
						<col width="5%" />
						<col width="20%" />
						<col width="10%" />
						<col width="25%" />
						<col width="5%" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
					</colgroup>
					<thead class="table-success">
						<tr>
							<th>#</th>
							<th>이메일</th>
							<th>회원이름</th>
							<th>주소</th>
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
								<td>${member.memberNum}</td>
								<td><a href="#">${member.memberEmail}</a></td>
								<td>${member.memberName}</td>
								<td>(${member.memberAddr1}) ${member.memberAddr2} ${member.memberAddr3}</td>
								<td>${member.memberCk}</td>
								<td>${member.memberPoint}</td>
								<td>${member.regDate}</td>
								<td>${member.loginType}</td>
								<td>
									<a href="/admin/manageMember/${member.memberNum}">
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
	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/fix/footer.jsp"></jsp:include>
	</footer>
</body>
<script type="text/javascript">

	$(function() {
		var update_result = "${updaet}";
		var delete_result = "${delete}";
		check_afterUpdate(update_result);
		check_afterDelete(delete_result);
	});

	function check_afterUpdate(result) {
		if (result == '') {
			return;
		}
		if (result == 'error') {
			alert("수정에 실패했습니다. 잠시후 다시 시도해주세요.");
			return;
		}

		alert("[" + result + "] 이(가) 수정되었습니다.");
	};

	function check_afterDelete(result) {
		if (result == '') {
			return;
		}
		if (result == 'error') {
			alert("삭제에 실패했습니다. 재고가 존재하는지 확인해주세요.");
			return;
		}

		alert("[" + result + "] 이(가) 삭제되었습니다.");
	};
	
	$("#pageForm a").click(function(e) {
		e.preventDefault();
		$("#pageForm").find("input[name='pageNum']").val($(this).attr("href"));
		$("#pageForm").attr("action", "/admin/manageGoods");
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
</script>
</html>