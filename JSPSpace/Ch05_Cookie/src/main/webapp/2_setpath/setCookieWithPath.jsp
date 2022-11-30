<%@page import="java.net.URLEncoder"%>
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
Cookie c1 = new Cookie("p1", URLEncoder.encode("경로:/Ch05_Cookie/2_setpath/path1", "utf-8"));
c1.setPath("/Ch05_Cookie/2_setpath/path1");
response.addCookie(c1);

// setPath를 사용하지 않은 경우 : default로 jsp를 실행한 path를 내부적으로 지정 (경로:/Ch05_Cookie/2_setpath)
Cookie c2 = new Cookie("p2", URLEncoder.encode("경로:", "utf-8"));
response.addCookie(c2);

Cookie c3 = new Cookie("p3", URLEncoder.encode("경로:"));
c3.setPath("/");
response.addCookie(c3);

Cookie c4 = new Cookie("p4", URLEncoder.encode("경로:/Ch05_Cookie/2_setpath/path2"));
c1.setPath("/Ch05_Cookie/2_setpath/path2");
response.addCookie(c4);

%>

<h3>쿠키 생성 내역</h3>
<p><%=c1.getName() %> = <%=c1.getValue() %> [<%=c1.getPath() %>]</p>
<p><%=c2.getName() %> = <%=c2.getValue() %> [<%=c2.getPath() %>]</p>
<p><%=c3.getName() %> = <%=c3.getValue() %> [<%=c3.getPath() %>]</p>
<p><%=c4.getName() %> = <%=c4.getValue() %> [<%=c4.getPath() %>]</p>
</body>
</html>