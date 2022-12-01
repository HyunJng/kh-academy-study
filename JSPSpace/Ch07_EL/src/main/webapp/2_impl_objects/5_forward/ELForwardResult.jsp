<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>String</h3>
<p>이름: ${requestScope.name }</p>

<h3>Member class filed정보 가져오기</h3>
<!-- m.getId()와 동일 => Member클래스에 getID가 있어야한다. -->
<p>아이디: ${requestScope.m.id }</p>
<p>이름: ${requestScope.m.name }</p>

<h3>HashMap정보 가져오기</h3>
<!-- pageContext, request, session, application 기본 객체에서 map이라는 key를 찾아 가져옴 -->
<p>이름: ${requestScope.map.name}</p>
<p>직업: ${map.job}</p>

<h3>List정보 가져오기</h3>
<p>첫번쨰 언어: ${requestScope.list[0] }</p>
<p>두번쨰 언어: ${list[1] }</p>

</body>
</html>