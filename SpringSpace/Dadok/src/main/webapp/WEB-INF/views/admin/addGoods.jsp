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
	<header>
		<jsp:include page="/WEB-INF/views/fix/gnb.jsp"></jsp:include>
	</header>
	<div class="container">
		<div id="admin_title"class="pt-4 pb-4 ps-3">
			<h1>관리자페이지</h1>
		</div>
		<div class="row mt-2">
			<jsp:include page="/WEB-INF/views/fix/admin_menu.jsp"></jsp:include>
			<div class="col-10">
				<div id="admin_subtitle" class="py-2 ps-2">
					<h4>상품 등록</h4>
				</div>
				<form class="py-2 row">
					<div class="col-8 m-0">
						<input class="form-control" type="text" id="query" placeholder="제목검색">
					</div>
					<button class="btn btn-secondary ms-1 col-2  px-1" type="submit" onclick="search_btn(); return false;">검색</button>
				</form>
				
				<div id="search_result">
				</div>
			</div>
		</div>
	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/fix/footer.jsp"></jsp:include>
	</footer>
</body>
<script type="text/javascript">
	$(function(){
		var add_result = "${result}"; 
		check_afterAdd(add_result);
	});

	function check_afterAdd(result) {
		if (result == '') {
			return;
		}
		if(result == 'error'){
			alert("이미 존재하는 책입니다. '상품관리' 페이지에서 확인해보세요");
			return;
		}
		
		alert("[" + result + "] 을(를) 등록했습니다.");
	};


			
	function search_btn() {
		var query = $('#query').val();
		var kakao_RestAPI = "49b76132d503d959eb5ed2d9603ed8f1";
		$.ajax({
					method : "GET",
					url : "https://dapi.kakao.com/v3/search/book?target=title",
					data : {
						"query" : query
					}, // 임시
					headers : {
						"Authorization" : "KakaoAK " + kakao_RestAPI
					},
					success : function(msg) {
						console.log(msg);
						$("#search_result").html("");
						for (var i = 0; i < 10; i++) {
							$("#search_result").append(
											"<div class='mt-2 p-2 border border-dark rounded'>"
													+ "<div class='h4'>"
													+ "<a href='/admin/addGoods/form?title="
													+ msg.documents[i].title
													+ "&bookImage="
													+ msg.documents[i].thumbnail
													+ "&author="
													+ msg.documents[i].authors
													+ "&publisher="
													+ msg.documents[i].publisher
													+ "&bookIntro="
													+ msg.documents[i].contents
													+ "&bookId="
													+ msg.documents[i].isbn
													+ "&fullPrice="
													+ msg.documents[i].price
													+ "'>"
													+ msg.documents[i].title
													+ "</a></div>"
													+ "<div class='row'>"
													+ "<div class='col-4'>"
													+ "<img src='" + msg.documents[i].thumbnail + "'/><br>"
													+ "</div>"
													+ "<div class='col-8'>"
													+ "<strong>저자:</strong> "
													+ msg.documents[i].authors
													+ "<br>"
													+ "<strong>출판사:</strong> "
													+ msg.documents[i].publisher
													+ "<br>"
													+ "<strong>요약:</strong> "
													+ msg.documents[i].contents
													+ "...<br>"
													+ "</div>"
													+ "</div>");
						}

					},
					error : function(error) {
						alert(error);
					}
				});
	};
</script>
</html>