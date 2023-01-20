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

<link rel="stylesheet" href="/resources/css/fix.css">
<link rel="stylesheet" href="/resources/css/mypage.css">

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
	<div class="wrap container">

		<jsp:include page="../fix/header.jsp"></jsp:include>
		
		<!-- 후원 main 이미지 -->
		<div class="row">
			<a href="/sponsor/get">
				<img id="id_map_img" class="col" alt="후원" src="/resources/image/sponsor/sponsorMain.jpg" usemap="#sponsor">
			</a>
<!-- 			<div name="sponsor">
				<area shape="rect" coords="730,558,1068,610"
					href="/sponsor/get/1">
					"/user/getSponsor"
			</div>
 -->
 		</div>
		
		<jsp:include page="../fix/footer.jsp"></jsp:include>
	</div>
		
	
    <script type="text/javascript">
        $(function(){
            $('#id_map_img').rwdImageMaps();
        });
    </script>
</body>
</html>