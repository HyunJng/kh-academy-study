<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apache Tomcat server의 정보</title>
</head>
<body>
<!-- Servlet version: 4.0 (Apache Tomcat 9.0.68)-->
<p>서버 정보 : <%= application.getServerInfo() %></p>
<p>Servlet 규약 major version : <%= application.getMajorVersion() %></p>
<p>Servlet 규약 minor version : <%= application.getMinorVersion() %></p>

<!-- url에서 context root path 정보를 가져오는 method -->
<p>Servlet Context 정보 : <%=application.getContextPath() %></p>
</body>
</html>