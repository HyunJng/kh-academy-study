<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page errorPage="/error/viewErrorMessage.jsp" %> --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parameter 출력</title>
</head>
<body>
<!-- 에러 처리 우선순위
1. page directive로 error을 처리할 jsp가 1순위로 실행
2. web.xml에서 지정한 exception class별로 error처리할 jsp page를 실행
3. web.xml에서 지정한 error-code에서 error처리할 jsp page를 실행
4. web page에 에러 내용이 그대로 보여짐
 -->
	<p>name parameter값: <%=request.getParameter("name").toString() %>
</body>
</html>