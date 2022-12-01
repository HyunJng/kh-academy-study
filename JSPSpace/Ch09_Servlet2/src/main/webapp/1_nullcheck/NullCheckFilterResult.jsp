<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- HttpServletRequest class의 인스턴스인 response를 실행하는 것이 아니라 
NullParameterRequestWrapper class의 override된 method를 실행함 -->
	<h3>NullCheck 결과 (id, name parameter에 적용)</h3>
	<p>id parameter : <%= request.getParameter("id") %></p>
	<p>name parameter : <%= request.getParameter("name") %></p>
	<p>member parameter : <%= request.getParameter("member") %></p>
	
</body>
</html>