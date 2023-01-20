<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" href="resources/css/style.css">
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
</head>
<body>
<!-- 1. 아이디 중복체크하고 넘어가도록 O
	 2. 비밀번호 확인 일치해야 넘어가도록
	 3. 전화번호에 숫자만 입력되기, 정규식으로 하이픈(-) 자동 넣어지도록
 -->
	<section class="login-form">

		<div>
			<img class="logo" src="resources/img/logo.jpg">
			<h1>회원가입</h1>
		</div>

		<form method="post" action="join" id="join-form">
			<div class="int-area">
				<input class="join-input-area" type="text" name="userId" id="userId" autocomplete="off" required>
				<label>아이디</label>
				<div class="btn">
					<button type="button" id="check-id">중복확인</button>
				</div>
			</div>
			
			<div class="int-area">
				<input type="password" name="userPw" id="userPw" autocomplete="off" required>
				<label>패스워드</label>
			</div>

			<div class="int-area">
				<input type="password" id="pwCheck" autocomplete="off"
					required> <label for="pwCheck">패스워드 확인</label>
			</div>
			
			<div class="int-area">
				<input type="text" name="userName"id="userName" autocomplete="off"
					required> <label for="userName">이름</label>
			</div>
			<div class="int-area">
				<input type="tel" name="userPhone" id="userPhone" autocomplete="off">
				<label>전화번호</label>
			</div>
			
			<div class="int-area">
				<input type="text" name="userEmail" id="userEmail" autocomplete="off">
				<label>이메일</label>
			</div>
			<div class="int-area">
				<input type="text" name="userAddr" id="userAddr" autocomplete="off">
				<label>주소</label>
			</div>
			
			<div class="caption">
				<div>
					<input id="member"class="remember" type="checkbox">
					<label for="member">회원 약관에 동의합니다.</label>
				</div>
				<div>
					<input id="individual" class="remember" type="checkbox">
					<label for="individual">개인정보 약관에 동의합니다.</label>
				</div>
			</div>
			
			<div class="btn-area">
				<button class="facebook" type="submit" onclick="checkSummit(); return false;">회원가입</button>
			</div>
			<div class="btn-area">
				<button class="default" type="button" onclick="location.href='/login'">로그인으로 돌아가기</button>
			</div>
			
		</form>
		
	</section>

	<script type="text/javascript">
		var id_check = false;
		
		$(function(){
			// 아이디 중복확인
			$('#check-id').click(function(){
				var userId = $('#userId').val();
				var userData = {"userId": userId}
	
				$.ajax({
					url: "/join/checkId",
					type: "post",
					data: JSON.stringify(userData),
					dataType: "json",
					contentType: "application/json",
					success: function(result){
						if(result == 0) {
							alert("가입이 가능한 아이디입니다.")
							id_check = true;
						} else if(result == 9) {
							alert("통신 오류");
						} else {
							alert("이미 존재하는 아이디입니다.")
						}
					},
					error : function(errorThrown){
						alert(errorThrown.statusText);
					}
				})
			})
		});

		function checkSummit(){
			// 비밀번호 확인
			var userPw = $('#userPw').val();
			var pwCheck = $('#pwCheck').val();
			if(userPw !== pwCheck){
				alert("비밀번호를 확인해주세요");
				return;
			}
			
			if(!($('#member').is(':checked') && $('#individual').is(':checked'))){
				alert("약관에 동의해주세요");
				return;
			} else if(id_check != true){
				alert("아이디 중복 확인해주세요");
				return;
			} else {
				alert("환영합니다");
				$('#join-form').submit();
			}
		}
		
    </script>
</body>
</html>
