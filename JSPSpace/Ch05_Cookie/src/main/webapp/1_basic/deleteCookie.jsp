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
			Cookie c1 = new Cookie("name", "");
			// setMaxAge : cookie의 생명주기 => 0초로 setting했다는 의미는 지금 삭제하라.
			c1.setMaxAge(0);
			response.addCookie(c1);
		}
	}
} 
%>
<p>name 이름을 가진 cookie를 삭제했습니다.</p>
</body>
</html>