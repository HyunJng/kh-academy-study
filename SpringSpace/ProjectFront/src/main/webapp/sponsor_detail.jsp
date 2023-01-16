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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="http://mattstow.com/experiment/responsive-image-maps/jquery.rwdImageMaps.min.js"></script>

<style type="text/css">
* {
	margin: 0;
	padding: 0;
	font-family: 'Noto Sans KR', sans-serif;
	
}

h1 {
	font-size: 35px bold;
}

h2 {
	font-size: 22px bold;
	border-top: 1px solid black;
	border-bottom: 1px solid black;
	padding: 2.4rem;
	margin-bottom: 1.5rem;
}

p {
	font-size: 17px;
}

form {
	float: none;
	margin: 0 auto;
}

.text-end {
  text-align: right !important;
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
		<section>
			<div class="row">
				<img class="col-12" src="resources/image/sponsor_content.png">
				<img class="col-12" src="resources/image/sponsorItem.png">
			</div>

			<form class="row justify-content-md-center" action="" method="post">
				<h2>굿즈 구매하기</h2>
				<div class="mb-3 col-10">
					<label class="form-label">후원자명</label> 
					<input class="form-control"
						 type="text"
						placeholder="session에서가져온이름" disabled>
				</div>
				<div class="mb-3 col-10">
					<label class="form-label">전화번호</label> 
					<input class="form-control"
						type="text"
						placeholder="session에서가져온 번호" disabled>
				</div>
				<div class="mb-3 col-10">
					<label class="form-label">주소</label> 
					<input class="form-control"
						type="text"
						placeholder="이미 적었으면 가져오고 null이면 API가져와서 선택하도록">
				</div>
				<div class="mb-3 col-10">
					<div class="row">
						<div class="col-xs-4 col-sm-6">
							<label class="form-label">이메일</label> 
							<input class="form-control" type="text" placeholder="아이디">
						</div>
						
						<div class="col-xs-4 col-sm-6">
							<label class="form-label" style="visibility: hidden;">빈공간</label>
							<select class="form-control" name="email_tail">
								<option value="@naver.com">naver.com</option>
								<option value="@daum.com">daum.com</option>
								<option value="@nate.com">nate.com</option>
							</select>
						</div>
					</div>
				</div>				
				<div class="mb-3 col-10">
					<label class="form-label">수량</label> 
					<input class="form-control" name=""
							type="number" min="1" max="100" value="1">
				</div>
				<div class="mb-3 col-10 form-check">
					<input type="checkbox" class="form-check-input">
					<label class="form-check-label" for="exampleCheck1">구매정보 확인했습니다.</label>
				</div>
				<div class="mb-3 col-10 text-end" id="totalPrice">
					<span class="">총 후원가격</span> 
					<p>&#8361 60000</p> <!-- 나중에 컨트롤러에서 계산해서 Model에 담아 표기${totalPrice} -->
				</div>
				<button type="submit" class="btn btn-primary col-10">Submit</button>
			</form>
		</section>
	</div>
</body>
</html>