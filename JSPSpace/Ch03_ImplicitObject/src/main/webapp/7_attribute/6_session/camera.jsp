<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카메라 구입 홈페이지</title>
</head>
<body>
	<%
	// 실제 프로젝트에서 사용하는 attribute value는 일반적으로 class의 인스턴스를 사용
	session.setAttribute("camera", "카메라");
	%>
	
	<h3>카메라를 장바구니에 담았습니다.</h3>
	<a href="notebook.jsp">노트북 매장 가기</a>
</body>
</html>