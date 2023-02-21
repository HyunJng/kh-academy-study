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