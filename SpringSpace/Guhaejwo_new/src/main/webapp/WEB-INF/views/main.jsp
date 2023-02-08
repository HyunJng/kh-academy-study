<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500;700&display=swap"
	rel="stylesheet">

<style type="text/css">
* {
	margin: 0;
	padding: 0;
	font-family: 'Noto Sans KR', sans-serif;
}

h1 {
	font-size: 35px bold;
	padding: 1.5rem 0;
	border-bottom: 1px solid black;
}

h2 {
	font-size: 22px bold;
}

p {
	font-size: 17px;
}

.carousel-inner>.carousel-item>img {
	top: 0;
	left: 0;
	max-height: 550px;
	margin: auto;
}

#adopt_list {
	float: none;
	margin: 100 auto;
	padding-top: 1.5rem;
}

#adopt_list>article {
	float: none;
	margin: 0 auto;
	margin-bottom: 50px;
}
#adopt_list>article>img {
	height: 250px;
}


/*     #adopt_list > article {
    	float: left;
    	margin-left: 10px;
    	margin-bottom: 10px;
    }
    #adopt_list > article > img {
    	display: block;
    	width: 400px;
    } */
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<jsp:include page="./fix/header.jsp"></jsp:include>

		<!-- 광고칸 -->
		<div id="advertisement">
			<div id="carouselExampleDark" class="carousel carousel-dark slide"
				data-bs-ride="carousel">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active" data-bs-interval="10000">
						<img src="resources/image/adver_01.png" class="d-block w-100"
							alt="광고_01">
					</div>
					<div class="carousel-item" data-bs-interval="2000">
						<img src="resources/image/adver_02.png" class="d-block w-100"
							alt="광고_02">
					</div>
				</div>

				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleDark" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleDark" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</div>

		<!-- 최근 입양글 -->
		<h1>강아지를 구해줘!</h1>
		<section id="latest_adopt">
			<div id="adopt_list" class="row row-cols-2 row-cols-lg-3 g-2 g-lg-4">
				<article class="col-md-4">
					<img class="img-thumbnail" alt="dog01"
						src="resources/adoptImg/dog1.jpg">
					<div>
						<span class="badge bg-secondary">입양대기</span> <span>강아지이름</span>
					</div>
				</article>
				<article class="col-md-4">
					<img class=" img-thumbnail" alt="dog01"
						src="resources/adoptImg/dog2.jpg">
					<div>
						<span class="badge bg-dark">입양완료</span> <span>강아지이름</span>
					</div>
				</article>
				<article class="col-md-4">
					<img class="img-thumbnail" alt="dog01"
						src="resources/adoptImg/dog3.jpg">
					<div>
						<span class="badge bg-dark">입양완료</span> <span>강아지이름</span>
					</div>
				</article>
				<article class="col-md-4">
					<img class="img-thumbnail mh-100" alt="dog01"
						src="resources/adoptImg/dog4.jpg">
					<div>
						<span class="badge bg-dark">입양완료</span> <span>강아지이름</span>
					</div>
				</article>
				<article class="col-md-4">
					<img class="img-thumbnail" alt="dog01"
						src="resources/adoptImg/dog5.jpg">
					<div>
						<span class="badge bg-dark">입양완료</span> <span>강아지이름</span>
					</div>
				</article>
				<article class="col-md-4">
					<img class="img-thumbnail mh-auto" alt="dog01"
						src="resources/adoptImg/dog1.jpg">
					<div>
						<span class="badge bg-dark">입양완료</span> <span>강아지이름</span>
					</div>
				</article>
			</div>
		</section>
		
		<!-- 광고 -->
		<div>
			<img alt="광고_03" class="d-block w-100" src="resources/image/adver_03.png">
		</div>
	</div>
</body>
</html>