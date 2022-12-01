<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- session객체 문제점
	- web browser마다 힙 메모리에 생성, client(PC, 모바일 폰) 수가 많아지면
	메모리에 점점 부족하게되어, web server의 전체 수행 속도를 느리게 하는 단점이 있다.
 -->
	<h3>쿠키 목록</h3>
	<ul>
	<%
	Cookie[] c = request.getCookies();
	if(c != null){
		for(int i = 0; i<c.length; i++){
			c[i].getValue(); ////////
		}
	}
	%>
	</ul>
</body>
</html>