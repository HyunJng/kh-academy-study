<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 초기화 parameter 읽어오기</title>
</head>
<body>
	<h1>초기화 parameter 목록</h1>
	<ul>
		<%
		/* 
		web.xml의 역할 : tomcat server가 project를 최초 실행할 때, 맨 처음에 읽는 파일
		- 여러가지 환경 정보가 setting, 특정 class에 대하여 instance를 자동 생성하여 background로 실행하는 설정 가능
		- web.xml에 <context-param> tag 사용법
		 . web application이 tomcat server에 의해 최초 실행할 때 설정 정보를 setting할 때 사용
		 
		*/
		// web.xml에 <context-param> tag
		Enumeration<String> initParam = application.getInitParameterNames();
		while(initParam.hasMoreElements()){
			String initParamName = initParam.nextElement();
		%>
		<li><%=initParamName %> : <%=application.getInitParameter(initParamName) %></li>
		<%
		}
		%>
	</ul>
</body>
</html>