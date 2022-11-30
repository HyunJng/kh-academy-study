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
 	// 원래는 post method에서 사용하는 encoding 설정 명령어
 	// 여기서는 <jsp:include> action tag로 다른 jsp의 한글 parameter를 전달할 떄 encoding설정 용도
 	request.setCharacterEncoding("utf-8");
 	%>
	<p>include전 name parameter값 : <%=request.getParameter("name") %> </p>
	<hr>
	<jsp:include page="bodySub.jsp">
		<jsp:param value="최범균" name="name"/>
	</jsp:include>
	<hr>
	<p>include후 name parameter값 : <%=request.getParameter("name")%></p>	
</body>
</html>