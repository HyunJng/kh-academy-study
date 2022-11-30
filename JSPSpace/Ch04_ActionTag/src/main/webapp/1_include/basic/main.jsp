<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>main.jsp에서 생성한 내용</p>

	<!-- <jsp:include> action tag 동작방법
	1. main.jsp의 sub.jsp가 각각 별도로 java code를 생성하고 servlet classㄷ 각각 생성됨
	2. main.jsp를 실행하는 중간에 <jsp:include>를 중간에 만나면 sub.jsp를 실행하고 
	   sub.jsp 실행이 끝나면 다시 main.jsp로 돌아와서 실행.
	3. 만약 sub.jsp가 새로운 내용으로 코딩이 되더라도 바뀐 sub.jsp내용이 반영됨.
		- include directive는 포함된 jsp가 새로운 내용으로 수정되어도 main.jsp에도 수정되지 않으면 반영되지 않음.
	 -->
	<jsp:include page="sub.jsp" flush="false" />
	<p>sub.jsp include 이후의 내용</p>
	
</body>
</html>
