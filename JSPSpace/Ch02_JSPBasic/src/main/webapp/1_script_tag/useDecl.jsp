<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- script declaration -->
<%!
	public int multiply(int a, int b){
		return a * b;
	}
	public int add(int a, int b){
		return a + b;
	}
	public int substract(int a, int b){
		return a - b;
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
10 * 25 = <%= multiply(10, 25) %> <br/>
<%
	int value1 = 3;
	int value2 = 9;
	
	int addResult = add(value1, value2);
	int substractResult = substract(value1, value2);
%>
<%= value1 %> + <%=value2 %> = <%= addResult %><br/>
<%= value1 %> - <%=value2 %> = <%= substractResult %>
</body>
</html>