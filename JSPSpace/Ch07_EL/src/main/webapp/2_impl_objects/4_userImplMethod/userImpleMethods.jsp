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
	request.setAttribute("name", "홍길동");
%>
<h3>기존 jsp코딩 방식</h3>
<%
	HttpServletRequest req = (HttpServletRequest)pageContext.getRequest();
%>
<p>요청 URI: <%=req.getRequestURI()%></p>
<p>요청 URI: <%=request.getRequestURI()%></p>

<h3>EL사용방식</h3>
<!-- request.getRequestURI()와 동일
pageContext, request, session, application 기본 객체의 
getter/setter메소드를 field이름을 사용하여 호출 가능
 -->
<p>요청 URI: ${requestScope.requestURI }</p>
<p>요청 URI: ${pageContext.request.requestURI }</p>
</body>
</html>