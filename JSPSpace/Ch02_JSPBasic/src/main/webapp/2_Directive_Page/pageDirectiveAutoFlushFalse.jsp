<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="1kb" autoFlush="true" %>
<!-- 1kb => 1024 byte -->
<!-- autoFlush : buffer가 꽉 차면 자동으로 buffer을 비울 것이냐? -->
<!-- 1. false : web browser에 보낼 때 전체 데이터가 buffer size보다 크면 Exception error -->
<!-- 2. 보통 autoFlush를 true로 지정(default) -->
<!-- 3. buffer sizze는 기본 8이고, 가능하면 많이 잡아 놓는 것이 좋다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>page autoFlush 속성값 false예제</h3>
	<%
		for(int i = 0; i < 1000; i++){
	%>
			<b>1234</b>
	<%			
		}
	 %>
</body>
</html>