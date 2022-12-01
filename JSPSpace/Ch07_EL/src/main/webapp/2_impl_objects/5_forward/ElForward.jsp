<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="p01.forward.Member"%>
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
	request.setAttribute("name", name);
	
	Member m = new Member();
	m.setId("admin");
	m.setName("김길동");
	request.setAttribute("m", m);
	
	Map<String, Object> map = new HashMap<>();
	map.put("name", "강감찬");
	map.put("job", "장군");
	request.setAttribute("map", map);
	
	List<String> list = new ArrayList<>();
	list.add("Java");
	list.add("JSP");
	request.setAttribute("list", list);
%>

<jsp:forward page="ELForwardResult.jsp"></jsp:forward>
</body>
</html>