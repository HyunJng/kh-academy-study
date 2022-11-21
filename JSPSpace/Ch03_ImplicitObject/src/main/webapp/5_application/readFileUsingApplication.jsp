<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStreamReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 기본 객체 사용하여 자원 읽기</title>
</head>
<body>
	<%
	String resourcePath = "/message/notice.txt";
	%>
	자원(resource)의 실제 경로(path) :
	<%=application.getRealPath(resourcePath)%>
	<p></p>
	<p>---------------------------------------------</p>
	<%=resourcePath%>파일의 내용
	<p>---------------------------------------------</p>
	<%
	char[] buff = new char[128];
	int len = -1;

	try (InputStreamReader is = new InputStreamReader(application.getResourceAsStream(resourcePath), "utf-8")) {
		while ((len = is.read(buff)) != -1)
			out.println(new String(buff, 0, len));
	} catch (IOException e) {
		out.println("Exception 발생: " + e.getMessage());
	}
	%>

</body>
</html>