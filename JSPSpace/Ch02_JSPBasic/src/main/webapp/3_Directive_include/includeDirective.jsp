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
		String name = "홍길동";
	%>
	<!-- include directive 
		1. jsp를 java file로 변환하기 전에 include directive로 사용된
		   모든 jsp파일이 하나로 협쳐짐
		2. 모두 합쳐진 jsp file이 java source로 변환됨 
		3. web page의 일부분인 header, footer처럼 공통으로 사용되는 
		   jsp page의 fragment를 별도 jsp 파일로 관리할 때 사용
		4. 단, include directive로 포함되는 jsp는 static정보만 가져옴  
		5. include directive로 포함된 jsp파일을 수정해도 새로운 java source로 자동 수정 안하는 단점 있음
	-->
	<%@ include file="top.jsp" %>
	<p>top.jsp입니다. 현재시간: <%=now.toString() %></p>
	<p>include directive를 포함하는 jsp는 include Directive.jsp입니다.</p>
	<p>이름은 <%= name %>입니다.</p>
	<%@ include file="bottom.jsp" %>
</body>
</html>