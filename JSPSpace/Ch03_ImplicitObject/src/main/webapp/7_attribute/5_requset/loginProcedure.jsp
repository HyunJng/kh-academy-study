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
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");

	String id = request.getParameter("id");
	String password= request.getParameter("password");
	
	request.setAttribute("id", id);
	request.setAttribute("password", password);
	%>
	
	<h3>LoginProcedure.jsp 본문 내용입니다.</h3>
	
	<%
	if(id.equals("admin") && password.equals("1234")){
	%>
	<!-- <jsp:forward> action tag는 request 객체를 다른 jsp로 직접 전달할 때 사용한다.
		참고로, 원칙적으로는 request 기본 객체는 web browser에서만 생성하여 전달 가능
	-->
		<jsp:forward page="loginSuccess.jsp"></jsp:forward>
	<%
	}else {
	%>
		<jsp:forward page="loginFail.jsp"></jsp:forward>
	<%
	}
	%>
</body>
</html>