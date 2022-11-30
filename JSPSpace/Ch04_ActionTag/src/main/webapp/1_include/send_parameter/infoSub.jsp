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
// request 기본 객체 : 원래 web browser에서 보낸 request 객체를 의미하고,
// <jsp:include> action tag를 호출한 jsp의 request 객체와 동일함.
String type = request.getParameter("type");
if (type == null) {
	return;
}
String id = request.getParameter("userid");
%>
<br>

<h3>ID : <%= id %></h3>

<table width="100%" border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td>타입</td> <td><%= type %></td>
	</tr>
	<tr>
		<td>특징</td>
		<td>
		<%
		if (type.equals("A")) {
		%>	
			강한 내구성
		<%
		} else if (type.equals("B")) {
		%>	
			뛰어난 대처 능력
		<%
		}
		%>
		</td>
	</tr>	
</table>

</body>
</html>
