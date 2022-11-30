<%@page import="p01.basic.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Member m = new Member();
	m.setName("홍길동");
%>

<h3>jstl core 사용</h3>
<!-- 
1. request.setAttribute("m", m) 와 동일한 기능
2. scope 속성 값을 지정하지 않으면 request가 기본
3. jstl도 기본적을 EL처럼 jsp의 기본객체 사용
4. <c set>에서 c는 core library의약어
-->
<c:set var="m" value="<%=m %>" scope="request"/>
<c:set var="name" value="${m.name}"/>
<p>name: ${name }</p>

<!-- m.setName("최범균") -->
<c:set target="${m }" property="name" value="최범균"/>
<p>2번쨰 name: <%=m.getName() %></p>
<c:set target="${m }" property="id" value="1234"/>
<p>id: <%=m.getId() %></p>
</body>
</html>