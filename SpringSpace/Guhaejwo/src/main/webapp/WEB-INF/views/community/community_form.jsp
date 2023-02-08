<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/resources/css/mypage.css">

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
	<div class="wrap container">
	
		<jsp:include page="../fix/header.jsp"></jsp:include>
		
		<section>

			<form class="flex justify-content-center" action="/new" method="post">
				<div>
                   <textarea name="title" id="title" rows="1" cols="55" placeholder="제목" maxlength="100" required></textarea>
				</div>
				<div id="in_content">
                   <textarea name="content" id="ucontent" placeholder="내용" rows="15" cols="55" required></textarea>
                </div>
                <input type="file" name="SelectFile" />
                <div class="bt_se">
                   <button type="submit">글 작성</button>
                </div>				
			</form>
		</section>
		<jsp:include page="../fix/footer.jsp"></jsp:include>
	</div>


</body>
</html>