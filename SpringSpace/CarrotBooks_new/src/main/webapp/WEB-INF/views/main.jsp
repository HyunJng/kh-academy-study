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
<link rel="stylesheet" href="resources/css/main.css">
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<title>Insert title here</title>
<style type="text/css">
	#logo {
	    display: flex;
    	justify-content: center;
    	align-items: center;
	}
	
	.main_title {
		background-color: #f4a460;
	}

	#newest_list {
		position: relative;
	}
	#newest_list ul {
		list-style: none;
		font-size: 0.9rem;
	}
	
	#newest_list a, #newest_list a:visited{
		text-decoration: none;
		color: black;
	}
	#newest_list a:hover {
		color: #FFC0CB;
	}
	
	#newest_list div[class='next']{
		position: absolute;
		top:45%;
		right: 0;
		align-items: center;
	}
	select[name='type'] {
		display: inline-block;
		width: 20%!important;
	}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/fix/gnb.jsp"></jsp:include>
	
	<div class="container">
		<header>
			<div class="row">
				<div class="col-2" id="logo">
					<img class="" alt="logo" src="/resources/image/logo.png" width="100%">
				</div>
				<div class="col-7 py-5 px-4">
					<div class="row border border-dark rounded-pill d-flex justify-content-center">
						<form action="/main/book" class="d-flex justify-content-between">
							<select name="type" class="form-select col-2 border-end">
								<option value="" class="">선택</option>
								<option value="T">제목</option>
								<option value="A">작가</option>
								<option value="N">내용</option>
								<option value="TN">제목+내용</option>
								<option value="P">출판사</option>
							</select> 
							<input class="border border-0 col-6" type="text">
							<button class="btn col-2">검색</button>
						</form>
					</div>
				</div>
				<div class="col-3">
				</div>
			</div>
			<div>
				<nav class="navbar navbar-expand-sm bg-light navbar-light">
				  <div class="container-fluid">
				    <ul class="navbar-nav">
				      <li class="nav-item">
				        <a class="nav-link active" href="#">베스트</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" href="#">신상품</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" href="#">고객센터</a>
				      </li>
				    </ul>
				  </div>
				</nav>
			</div>
		</header>
		
		<!-- 광고판  -->
		<div>
			<div id="demo" class="carousel slide" data-bs-ride="carousel">

			  <!-- Indicators/dots -->
			  <div class="carousel-indicators">
			    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
			    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
			  </div>
			
			  <!-- The slideshow/carousel -->
			  <div id="advertDiv" class="carousel-inner">
 				<%
					List<AttachImageVO> list = (List<AttachImageVO>)request.getAttribute("advertList");
					for(AttachImageVO vo : list){
						String fileCallPath = "advert/" + vo.getUploadPath().replace("\\", "/") + "/" + vo.getUuid()+"_" + vo.getFileName();
				%>
					<div class="carousel-item active">
						<img src='/display?fileName=<%=fileCallPath %>' class="d-block w-100">
					</div>
				<%
					}
				%>
						
			  </div>
			
			  <!-- Left and right controls/icons -->
			  <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
			    <span class="carousel-control-prev-icon"></span>
			  </button>
			  <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
			    <span class="carousel-control-next-icon"></span>
			  </button>
			</div>
		</div>
		
		<!-- 신간 -->
		<div>
			<div class="main_title">
				<h2 class=" my-1 p-3">오늘의 신간</h2>
			</div>
				
			<div id="newest_list" class="carousel slide mt-3 border rounded-1" >
				<!-- The slideshow/carousel -->
				<div class="carousel-inner ms-6">
					<div class="carousel-item active">
						<ul class="row">
						    <c:forEach var="book" items="${newestList}" begin="0" end="3">
								<li class="col pt-2">
									<p>
										<a href="#"><img alt="신간" src="${book.bookImage}"></a>
									</p>
									<div>
										<p><a href="#">${book.title}</a></p>
										<p>${book.author}</p>
										<p>${book.fullPrice}</p>
									</div>
								</li>
							</c:forEach>
					    </ul>
					</div>
					<div class="carousel-item">
					    <ul class="row">
						    <c:forEach var="book" items="${newestList}" begin="4" end="7">
								<li class="col pt-2">
									<p>
										<a href="#"><img alt="신간" src="${book.bookImage}"></a>
									</p>
									<div>
										<p><a href="#">${book.title}</a></p>
										<p>${book.author}</p>
										<p>${book.fullPrice}</p>
									</div>
								</li>
							</c:forEach>
					    </ul>
					</div>
				</div>
					
				<!-- Left and right controls/icons -->
				<button class="carousel-control-prev" type="button" data-bs-target="#newest_list" data-bs-slide="prev">
					    <span><img alt="prev" src="/resources/image/tempImage/prev.png" width="50px"></span>
				</button>
				<button class="carousel-control-next" type="button" data-bs-target="#newest_list" data-bs-slide="next">
					    <span><img alt="next" src="/resources/image/tempImage/next.png" width="30px"></span>
				</button>
			</div>
		</div>
		
	</div>
	
	<footer>
		<jsp:include page="/WEB-INF/views/fix/footer.jsp"></jsp:include>
	</footer>
</body>
<script type="text/javascript">

/* 광고판 JSON으로 가져오려다가 실패...
	$(function(){
		let targetDiv = $("#advertDiv");
 		$.getJSON("/getAttachList", function(arr){
			let str="";
 			for(let i = 0; i < arr.length; i++){
				let fileCallPath = "advert/" + arr[i].uploadPath.replace(/\\/g, '/') + "/" + arr[i].uuid +"_" + arr[i].fileName;
				console.log(arr[i]);
				console.log(fileCallPath);
				str += '<div class="carousel-item active">';
				str += "<img src='/display?fileName=" + fileCallPath +"'>";
				str += '</div>';
				targetDiv.append(str);
			} 
		})
		
	});
		*/
</script>
</html>