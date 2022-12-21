<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>1234</p>
	   <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
	   <c:choose>
	   		<c:when test="${resultList == null }">
	   			카트가 비었습니다
	   		</c:when>
	   </c:choose>
	   <c:forEach items="${resultList }" var="board">
	   	${board.seq }
	   
	   </c:forEach>
</body>
</html>