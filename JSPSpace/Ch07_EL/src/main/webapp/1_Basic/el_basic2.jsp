<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
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
	String[] dept = {"인사", "재무", "개획", "영업"};
	ArrayList<String> className = new ArrayList<>();
	className.add("SQL응용");
	className.add("JSP/Servlet");
	className.add("JavaScript");
	HashMap<String, String> map = new HashMap<>();
	map.put("deptname", "컴공");
	map.put("name", "강준상");
	map.put("title", "학생");
	map.put("tel", "010-0505-0522");
	
	request.setAttribute("className", className);
	request.setAttribute("dept", dept);
	request.setAttribute("map", map);
	%>
	<!-- 
	1) java변수를 사용하려면 반드시 request, pageContext, session, application 등 기본 객체에 setAttribute로 등록해야함
	2) 사용하는 변수 명은 setAttribute의 key로 사용한 이름
	 -->
	<h3>1. 회사부서</h3>
	<p>0번째 부서: ${dept[0]}</p>
	<p>1번째 부서: ${dept[1]}</p>
	<p>2번째 부서: ${dept[2]}</p>
	<p>3번째 부서: ${dept[3]}</p>
	<hr>
	<h3>2. Class이름</h3>
	<p>0번째 class: ${className[0]}</p>
	<p>1번째 class: ${className[1]}</p>
	<p>2번째 class: ${className[2]}</p>
	<hr>
	<h3>3. 부서정보</h3>
	<p>학과 : ${map.get("deptname")}</p>
	<p>성명 : ${map.get("name")}</p>
	<p>타이틀: ${map.get("title")}</p>
	<p>전화: ${map.get("tel")}</p>
	<hr>
</body>
</html>