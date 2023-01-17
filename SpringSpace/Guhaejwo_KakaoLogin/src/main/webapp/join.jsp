<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" href="resources/css/style.css">
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
</head>
<body>
	<section class="login-form">

		<div>
			<img class="logo" src="resources/img/logo.jpg">
			<h1>회원가입</h1>
		</div>


		<form action="">
			<div class="int-area">
				<input type="text" name="userId" id="userId" autocomplete="off" required>
				<label for="id">아이디</label>
			</div>
			<div class="int-area">
				<input type="password" name="userPw" id="userPw" autocomplete="off" required>
				<label for="pw">패스워드</label>
			</div>
<!-- 			
			<div class="int-area">
				<input type="password" name="pwc" id="pwc" autocomplete="off"
					required> <label for="pwc">패스워드 확인</label>
			</div>
-->	
			<div class="int-area">
				<input type="password" name="userPhone" id="userPhone" autocomplete="off" required>
				<label for="pn">전화번호</label>
			</div>
			<div class="int-area">
				<input type="password" name="userEmail" id="userEmail" autocomplete="off" required>
				<label for="ea">이메일</label>
			</div>
			<div class="int-area">
				<input type="password" name="userAddr" id="userAddr" autocomplete="off" required>
				<label for="ar">주소</label>
			</div>
			<div class="btn-area">
				<button id="btn" class="default" type="submit">회원가입</button>
			</div>

		</form>
		<div class="caption">
			<div>
				<input class="remember" type="checkbox" value="remember-id">
				회원 약관에 동의합니다.
			</div>
			<div>
				<input class="remember" type="checkbox" value="remember-id">
				개인정보 약관에 동의합니다.
			</div>
		</div>
	</section>

	<script>


    </script>
</body>
</html>
