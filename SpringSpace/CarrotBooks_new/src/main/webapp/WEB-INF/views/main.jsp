<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/fix/gnb.jsp"></jsp:include>
	</header>
	
	<div class="container">
		<header class="row">
			<div class="col-2" id="logo">
				<img class="" alt="logo" src="/resources/image/logo.png" width="100%">
			</div>
			<div class="col-7 py-5 px-4">
				<div class="border border-dark rounded-pill d-flex justify-content-center">
					<input class="border border-0" type="text">
					<button>검색</button>
				</div>
			</div>
			<div class="col-3">
				<!-- 나중에 광고나 뭐 넣기 -->
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
			  <div class="carousel-inner">
<%--
 			  	<c:forEach var="advert" items="${advertList}">
				    <div class="carousel-item active">
				      <img src="/display?fileName=advert/${advert.uploadPath}/${advert.uuid}/${advert.fileName}" alt="advert" class="d-block w-100">
				    </div>
			  	</c:forEach>
 --%>
 				    <div class="carousel-item active">
				      <img src="/resources/image/tempImage/advert1.jpg" alt="advert" class="d-block w-100">
				    </div>
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

</script>
</html>