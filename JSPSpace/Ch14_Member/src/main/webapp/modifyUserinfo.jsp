<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	input[readonly]{
		background-color : lightgrey;
	}
	li {
		list-style-type:none;
	}
</style>
</head>
<body>
	<h1>회원 수정</h1>
	<form action="modifyUser.do" method="post">
		<ul>
			<li>이름 <input type="text" name="username" value="${authUser.name }" ></li>
			<li>아이디 <input type="text" name="userid" value="${authUser.id }" readonly></li>
			<li>비밀번호* <input type="text" name="password" value="${authUser.password }" id="pwd" required></li>
			<li>비밀번호 확인* <input type="text" id="check_pwd" required></li>
			<li>이메일 <input type="text" name="email" value="${authUser.email}"></li>
			<li>전화번호<input type="text" name="tel" value="${authUser.tel}"></li>
			<li>등급
				<label><input type="radio" name="level" value="user" id="level_user">일반회원</label>
				<label><input type="radio" name="level" value="admin" id="level_admin">관리자</label>
			</li>
			<li>
				<input type="submit" value="확인" id="submit">
				<button type="button" onclick="location.href='membersOnly.jsp'">취소</button>
			</li>
		</ul>
	</form>
	
	<script type="text/javascript">
		// 기존 level 확인
		var level = "${authUser.level}";
		if(level === "admin"){
			$('#level_admin').attr("checked", true);
		}else {
			$('#level_user').attr("checked", true);
		}
		
		// password 확인
		$(function(){
			$("#submit").click(function(){
				var password = $('#pwd').val();
				var chkPassword = $('#check_pwd').val();
				
				if(password === chkPassword){
					return true;
				} else {
					alert("비밀번호를 다시 확인하세요.");
					$('#check_pwd').focus();
					return false;
				}
			})
		})
	</script>
</body>
</html>