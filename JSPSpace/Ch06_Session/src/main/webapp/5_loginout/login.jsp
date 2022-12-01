<%@page import="member.MemberInfo"%>
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
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	// 로그인 성공 여부 : id와 password가 동일한지 여부
	if(id.equals(password)){
		MemberInfo member = new MemberInfo();
		member.setId(id);
		member.setPasswd(password);
		session.setAttribute("MEMBER", member);
	%>
		<p>로그인에 성공했습니다</p>
	<%
	}else{
	%>
	<script>
		window.alert("로그인에 실패하였습니다.");
		history.go(-1); //바로 이전 페이지로 이동
	</script>
	<%
	}
	%>
</body>
</html>