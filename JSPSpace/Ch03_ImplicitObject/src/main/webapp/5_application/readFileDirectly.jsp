<%@page import="java.io.IOException"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>절대 경로(absolute path)를 사용하여 자원(resource) 읽기</title>
</head>
<body>
	<%
	char[] buff = new char[128];

	int len = -1;
	String filePath = "C:\\temp\\notice.txt";

	try (InputStreamReader is = new InputStreamReader(new FileInputStream(filePath), "utf-8")) {
		while ((len = is.read(buff)) != -1)
			out.println(new String(buff, 0, len));
	} catch (IOException e) {
		out.println("Exception 발생: " + e.getMessage());
	}
	%>
</body>
</html>