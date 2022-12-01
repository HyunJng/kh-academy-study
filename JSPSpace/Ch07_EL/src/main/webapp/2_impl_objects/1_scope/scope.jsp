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
	pageContext.setAttribute("scope_name", "context_scope");
	request.setAttribute("scope_name", "request_scope");
	session.setAttribute("scope_name", "session_scope");
	session.setAttribute("age", 24);
	application.setAttribute("scope_name", "application_scope");
	application.setAttribute("dept", "sales");
%>
<!-- 
1) pageScope : EL에서 사용하는 pageContext 객체 이름
2) requestScope : El에서 사용하는 request객체 이름
3) sessionScope : El에서 사용하는 session객체 이름
4) applicationScope : El에서 사용하는 application객체 이름
 -->
<p>page scope : ${pageScope.scope_name }</p>
<p>request scope : ${requestScope.scope_name }</p>
<p>session scope : ${sessionScope.scope_name }</p>
<p>session scope : ${sessionScope.age }</p>
<p>application scope : ${applicationScope.scope_name }</p>
<!-- EL에서 기본객체이름을 사용하지 않고 key만 사용할 경우
- EL에서 해당 키값에 대하여 pageContext, request, session, application 순서대로 추적하여 결과를 가져옴
 -->
<p>영업부서명 : ${dept }</p> 
</body>
</html>