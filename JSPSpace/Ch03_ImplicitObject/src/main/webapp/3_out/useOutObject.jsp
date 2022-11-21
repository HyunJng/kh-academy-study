<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
</form>
<%
	int grade = 0;
	if(request.getParameter("grade") != null){
		grade = Integer.parseInt(request.getParameter("grade"));
	}
	
	if (grade > 10){
		out.println("grade : A 등급");
	}else if (grade > 5)
		out.println("grade : B 등급");
	else
		out.println("grade : C 등급");
%>
<!-- 
 response, request 기본 객체
 - web browser에서 새로운 서비스ㅡㄹ 요청할 때마다 새로 생성
 server에서 web browser에 요청이 완료되면 메모리에 삭제됨
 
 session 기본 객체
 - web browser 1개마다 생성이 됨
 - session 기본 객체가 web browser에서 살아있는동안 여러 개의 requeset, response객체가 생성되고 삭제됨
 
 application 기본 객체
 - application 이 실행 시작되어서 종료될 떄까지 1개만 생성되어 윶됨
 - project를 tomcat server가 실행하면 application객체가 생성되고
 server을 중지하면 application객체가 삭제된다.
 - 1개의 applicaton 객체에 여러 개의 session객체가 존재할 수 있다.
 - 현재 tomcat server로 실행중인 1개의 project에 대한 context정보를 갖고 있다.
 
 jspContext : jsp page에 대한 기본객체 (jsp page와 1:1관계)
 
 context : 1개의 project실행 : application
 
 WAS(tomcat server) - web container
 - 여러개의 web application 실행 가능
 - 메모리에서 실행되고 잇는 각각의 web application 은 application 기본객체 (servlet context객체)를 가지고 있다.
 
 -->
	<h3>out 객체 method 사용</h3>
	<p>버퍼 크기 : <%= out.getBufferSize()%></p>
	<p>남은 크기 : <%= out.getRemaining()%></p>
	<p>auto flush 여부 : <%= out.isAutoFlush()%></p>
</body>
</html>