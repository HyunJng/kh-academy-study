<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" scope="request" class="member.MemberInfo"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		[useBean.jsp에서의 jsp:useBean action tag 처리 방법]
		1. if(member == null)
		   { MemberInfo member = new MemberInfo();}
		   else {member = request.getAttribute("member");}
	 -->
	<p><%=member.getName() %> (<%=member.getId() %>) 회원님, 안녕하세요.</p>
	
</body>
</html>