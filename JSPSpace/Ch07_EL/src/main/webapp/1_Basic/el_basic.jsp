<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- EL(Expression Language) Data Type 종류 -->
<ul>
	<li>정수형 : ${10 }</li>	
	<li>실수형 : ${5.0}</li>	
	<li>문자열형 : ${"홍길동"}</li>	
	<li>논리형 : ${true}</li>	
	<li>null : ${null }</li>	
	
	<li>덧셈연산 : ${5+2}</li>
	<li>나누기연산: ${5/2}</li>
	<li>나머지 : ${5 mod 2}</li>
	<li>논리연산 : ${5 > 2}</li>
	<li>논리연산 : ${5 gt 2}</li>
	<li>삼항연산자 : ${(5>3) ? 5 : 2}</li>
	<%String input = null; %>
	<li>pull check : ${empty input}</li>
</ul>
<!-- 1. scriptlet expression을 사용하여 JSP화면에 변수값을 출력 -->
<% String name= "honggildong"; 
	pageContext.setAttribute("page_name", name);
%>
<!-- 2. EL을 사용하여 표현 : 간결한 코딩을 목적으로 사용-->
${page_name}
</body>
</html>