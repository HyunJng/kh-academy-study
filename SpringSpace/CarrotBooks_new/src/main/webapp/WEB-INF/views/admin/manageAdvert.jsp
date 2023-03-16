<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/admin/main.css">
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<title>Insert title here</title>
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
					<h4>광고 관리</h4>
				</div>
				<form id="search_form" action="/admin/manageAdvert" class="py-2 row">
					<div class="col-2">
						<select name="type" class="form-select">
							<option value="" class="">선택</option>
							<option value="N" >광고이름</option>
							<option value="P" >담당자</option>
							<option value="B" >책</option>
						</select>
					</div>
					<div class="col-5 m-0">
						<input class="form-control" type="text" name="keyword" placeholder="검색어입력">
					</div>
					<button class="btn btn-secondary ms-1 col-2  px-1" type="submit">검색</button>
					<button class="btn btn-light ms-1 col-2  px-1" type="button" onclick="location.href='/admin/manageAdvert/add'">광고 추가</button>
				</form>
				
				<table class="table">
					<colgroup>
						<col width="5%" />
						<col width="20%" />
						<col width="10%" />
						<col width="10%" />
						<col width="15%" />
						<col width="20%" />
						<col width="25%" />
					</colgroup>
					<thead class="table-success">
						<tr>
							<th>#</th>
							<th>광고 이름</th>
							<th>등록일</th>
							<th>마감일</th>
							<th>담당자</th>
							<th>계약회사</th>
							<th>관련책/이미지보기</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="advert" items="${advertList}">
							<tr>
								<td>${advert.advertId }</td>
								<td>${advert.advertName }</td>
								<td>${advert.regDate }</td>
								<td>${advert.endDate }</td>
								<td>${advert.uploaderName }</td>
								<td>${advert.company }</td>
								<td>
									<button id="imagebtn" type="button" class="btn btn-sm btn-light" data-bs-toggle="modal" data-bs-target="#myModal" onclick="showImage(${advert.advertId})">이미지</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<!-- 이미지 출력 -->
				<div class="modal" id="myModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<!-- Modal body -->
							<div class="modal-body d-flex justify-content-center">
								
							</div>

						</div>
					</div>
				</div>

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
/* 광고 저장하고 온 상태인지 확인 */
$(function(){
	var add_result = "${save}"; 
	check_afterAdd(add_result);
});

function check_afterAdd(result) {
	if (result == '') {
		return;
	}
	if(result == 'error'){
		alert("저장할 떄 문제가 발생했습니다. 다시 시도해주세요.");
		return;
	}
	
	alert("[" + result + "] 을(를) 등록했습니다.");
};

/* 페이징 처리 */
$("#pageForm a").click(function(e) {
	e.preventDefault();
	$("#pageForm").find("input[name='pageNum']").val($(this).attr("href"));
	$("#pageForm").attr("action", "/admin/manageAdvert");
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

/* 이미지 출력  */
function showImage(id){
	let target = id;
	let targetDiv = $(".modal-body");
	
	$.getJSON("/admin/getAttachList", {refId:target}, function(arr){
		let str ="";
		let obj = arr[0];
		
		let fileCallPath = "advert/"+obj.uploadPath.replace(/\\/g, '/') + "/"+obj.uuid+"_"+obj.fileName;
		console.log(fileCallPath);
		str+="<img width='400px' src='/display?fileName=" + fileCallPath +"'>";
		targetDiv.html(str);
	})
}

</script>
</html>