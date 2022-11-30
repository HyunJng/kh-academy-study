<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" scope="request" class="member.MemberInfo" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 	<%
 	/*
	[<jsp:useBean> action tag 기능]
	* 전제 조건으로 기존에 member이 null일 경우에 1,2,3이 실행
	1. member.MemberInfo member = new memer.MemberInfo(); 실행
	  - id attribute의 value인 member가 인스턴스이름
	2. request.setCharaterEncoding(); => pageEncoding 사용
	3. request.setAttribute("member", member); 으로 저장 
	
	[jsp:useBeand의 활용]
	1. web browser와 web server의 jsp간의 정보 전달할 때도 사용
	2. web server내에서 jsp간 정보 전달할 때도 사용
 	*/
 
 
	/* java bean의 값 설정하는 것은 class setter 사용 */
	member.setId("hong");
	member.setName("홍길동");
	%>
	<jsp:forward page="useBean.jsp" />
</body>
</html>