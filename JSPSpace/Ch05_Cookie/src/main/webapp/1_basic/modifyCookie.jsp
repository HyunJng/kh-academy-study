<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Cookie[] c = request.getCookies();
if ( c!= null && c.length > 0) {
	for (int i=0; i<c.length; i++) {
		if (c[i].getName().equals("name")) {
			Cookie c1 = new Cookie("name", "JSP");
			// addCookie 내부 구현 기능 : 
			// 1. 기존에 cookie 이름으로 등록된 cookie가 없는 경우에는 cookie에 새로 추가가 되고
			// 2. 기존에 cookie 이름이 존재하면, value 값만 수정
			response.addCookie(c1);
		}
	}
} 
%>
<p>name 이름을 가진 cookie를 변경했습니다.</p>
</body>
</html>