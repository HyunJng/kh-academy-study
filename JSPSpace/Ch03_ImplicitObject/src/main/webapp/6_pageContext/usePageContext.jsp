<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pageContext 기본 객체 사용</title>
</head>
<body>
<% 
	HttpServletRequest httpReq = (HttpServletRequest)pageContext.getRequest();
	HttpServletResponse httpResp = (HttpServletResponse)pageContext.getResponse();
	
	ServletContext servletContext = pageContext.getServletContext();
%>

<h3>pageContext를 사용하여 얻은 객체와 기본 객체를 비교하기</h3>
<p>httpRequest와 request기본객체 비교하기 : <%=(httpReq == request) %></p>
<p>httpResponse와 response기본객체 비교하기 : <%=(httpResp== response) %></p>
<p>ServletContext와 application기본객체 비교하기 : <%=(servletContext == application) %></p>

</body>
</html>