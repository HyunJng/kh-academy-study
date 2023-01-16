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
	int sum = 0;
	
	for(int i= 0; i<=10; i++){
		sum += i;
	}
%>

1부터 10까지의 합은 <%= sum %>입니다..<br/>

1부터 10까지의 합을 expression으로 표현해도 <%= 1+2+3+4+5+6+7+8+9+10 %>입니다..
</body>
</html>