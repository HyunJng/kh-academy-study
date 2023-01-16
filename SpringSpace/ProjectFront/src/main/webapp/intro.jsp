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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	font-family: 'Noto Sans KR', sans-serif;
}

h1 {
	font-size: 35px bold;
	padding: 1.5rem 1rem;
	background-color: #62584D;
	color: white;
	border-radius: 8px;
	
}

h2 {
	font-size: 22px bold;
}

p {
	font-size: 17px;
}

button {
	margin-right: 10px;
	margin-bottom: 1.5rem;
	
}
#intro{
	background-color: #FD8A69;
}
#team{
	background-color: #FFFAF3;
}

</style>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<!-- 삭제할  header-->
		<header
			class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
			<a href="/"
				class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
				<svg class="bi me-2" width="40" height="32">
					<use xlink:href="#bootstrap"></use></svg> <span class="fs-4">Simple
					header</span>
			</a>

			<ul class="nav nav-pills">
				<li class="nav-item"><a href="#" class="nav-link active"
					aria-current="page">Home</a></li>
				<li class="nav-item"><a href="#" class="nav-link">Features</a></li>
				<li class="nav-item"><a href="#" class="nav-link">Pricing</a></li>
				<li class="nav-item"><a href="#" class="nav-link">FAQs</a></li>
				<li class="nav-item"><a href="#" class="nav-link">About</a></li>
			</ul>
		</header>
		
		<!-- page title  -->
		<div>
			<h1>구해줘!펫즈 소개</h1>	
			<div>
				<button id="intro" type="button" class="btn btn-lg" >구해줘!펫즈 소개</button>
				<button id="team" type="button" class="btn btn-lg">팀원 소개</button>
			</div>
		</div>
		
		<!-- 사이트 소개 -->
		<div class="row">
			<div class="col-md-5">
				<img class="img-thumbnail" src="resources/image/dog.jpg">
			</div>
			
			<div class="col-md-7">
				<h2>유기견입양이 접근성있어지길 바라며</h2>
				<p>2020말 기준  4명 중 1명은 반려동물을 기를 정도로 한국인들의 반려동물 관심은 급상승하였습니다.<br>
				 하지만 입양에 대한 관심과 함께 반려동물 파양 및 유기동물도 상당히 늘어났습니다.<br>
				 이에 대응하여 몇몇 개인분들이 유기동물을 임시보호하고 주인을 찾아주려는 노력을 하지만,
				 유기견을 입양할 수 있는 하나의 통합된 사이트가 존재하지 않아 여러 보호소 사이트 뿐만 아니라 네이버 카페나 인스타,트위터와 같은 여러 SNS에 의존하고있는 실태입니다.<br>
				 이러한 상황에서 입양자가 원하는 조건의 아이를 만나는 것이 쉽지만은 않고 이것이 유기견입양에 거리감이 생기는 원인 중 하나라고 파악했습니다.<br>
				 그래서 저희는 임시보호되는 아이들과 입양 의사가 있는 분들의 만남의 장을 만들어 유기견 입양이 더 가까워지게 하는 것을 목표로 프로젝트를 시작하였습니다. 
				 </p>
			</div>
		</div>
	</div>
</body>
</html>