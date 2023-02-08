<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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