<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>쿠키 목록</h3>
<ul>
<%
// web browser에서 server로 cookie를 전송할 때
// 1. request header의 Cookie라는 속성에 넣어서 전달
// 2. Cookie 속성에 여러 개의 cookie들을 저장하고, cookie들간의 구분자는 ';'을 사용
Cookie[] c = request.getCookies();
if ( c!= null && c.length > 0) {
	for (int i=0; i<c.length; i++) {
%>		
	<li><%=c[i].getName() %> : <%=URLDecoder.decode(c[i].getValue(), "utf-8") %></li>
<%
	}
} else {
%>
	<li>쿠키가 존재하지 않습니다.</li>
<%	
}
%>
</ul>
</body>
</html> urldecoder