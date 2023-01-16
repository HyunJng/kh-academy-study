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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="http://mattstow.com/experiment/responsive-image-maps/jquery.rwdImageMaps.min.js"></script>

<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

h1, h2, p {
	font-family: 'Noto Sans KR', sans-serif;
}

h1 {
	font-size: 35px bold;
}

h2 {
	font-size: 22px bold;
}

p {
	font-size: 17px;
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
		<!-- 후원 main 이미지 -->
		<div class="row">
			<img id="id_map_img" class="col" alt="후원" src="resources/image/sponsorMain.jpg" usemap="#sponsor">
			<map name="sponsor">
				<area shape="rect" coords="730,558,1068,610"
					href="sponsor_detail.jsp">
			</map>
		</div>
	</div>
	
    <script type="text/javascript">
        $(function(){
            $('#id_map_img').rwdImageMaps();
        });
    </script>
</body>
</html>