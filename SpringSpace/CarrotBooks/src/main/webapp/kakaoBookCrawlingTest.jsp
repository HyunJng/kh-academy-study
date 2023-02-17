<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
</head>
<body>
	<div id="html"></div>
	<button id="btn">버튼</button>
</body>
<script type="text/javascript">
	$("#btn").click(function(){
		var kakao_RestAPI = "49b76132d503d959eb5ed2d9603ed8f1";
		$.ajax({
			method : "GET",
			url : "https://dapi.kakao.com/v3/search/book?target=title",
			data : {"query":"미움받을용기"},
			headers:{"Authorization":"KakaoAK "+ kakao_RestAPI},
			success: function(msg){
				console.log(msg);
				$("#html").html(JSON.stringify(msg, null, 2));
			},
			error: function(error){
				alert(error);
			}
		});
	});
</script>
</html>