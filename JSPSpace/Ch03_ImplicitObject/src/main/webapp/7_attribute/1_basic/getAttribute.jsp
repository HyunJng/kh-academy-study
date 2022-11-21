<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>getAttribute.jsp에서 request, session, application attribute 설정값 추출</h3>
	<!-- request 객체에 설정된 정보를 가져오면 null값 가져옴 
	: request기본 객체는 web browser에서 web server로 요청할때마다 새로 생성되기 떄문에 
	기존 request객체에 설정된 attribute는 존재하지 않는다.-->
	<p>request :: <%=request.getAttribute("id") %></p> <!-- 새로운 요청이 발생했으므로 이전 request정보 사라짐 -->
	<p>session :: <%=session.getAttribute("id") %></p> <!-- web browser이 살아있어서 정상작동 -->
	<p>application :: <%=application.getAttribute("id") %></p> <!-- 같은 application안이라서 정상 작동 -->
</body>
</html>