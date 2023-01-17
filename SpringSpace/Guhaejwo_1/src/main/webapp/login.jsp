<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<link rel="stylesheet" href="resources/css/style.css">
<title>Document</title>
</head>
<body>
	<section class="login-form">
		<div>
			<img class="logo" src="/img/logo.jpg">
		</div>

		<form>
			<div class="int-area">
				<input type="text" name="userId" id="userId" autocomplete="off"
					required> <label for="userId">아이디</label>
			</div>
			<div class="int-area">
				<input type="password" name="userPw" id="userPw" autocomplete="off"
					required> <label for="userPw">패스워드</label>
			</div>

			<div class="btn-area">
				<button id="btn" class="default" onclick="login(); return false;">로그인</button>
			</div>

			<!--             <div class="btn-area">
                <button id="btn"
                type="button" class="kakao">카카오 로그인</button>
            </div>
            <div class="btn-area">
                <button id="btn"
                type="button" class="facebook">페이스북 로그인</button>
            </div>
             -->
			<div class="caption">
				<input class="remember" type="checkbox" id="rememberId"> ID
				기억하기
			</div>
		</form>
		
		<div class="caption">
			<div>
				<a href="#">비밀번호 찾기</a>
			</div>
			<div>
				<a href="/join">회원가입</a>
			</div>
		</div>
	</section>

	<script type="text/javascript">
		$(function() {
			/* 저장된 아이디 불러오기 */
			var rememberId = localStorage.getItem("saveId")

			if (rememberId != 'N') {
				$('#userId').val(rememberId);
			}
		})
		
		function login() {
			var userId = $('input[name="userId"]').val();
			var userPw = $('input[name="userPw"]').val();
			var rememberId = $('#rememberId:checked').val();
			
			/* 아이디 저장  유무 판별 */
			if (rememberId == 'on') {
				localStorage.setItem("saveId", userId);
			} else {
				localStorage.setItem("saveId", 'N');
			}

			/* 로그인 용 */
			var userData = {
				"userId" : userId,
				"userPw" : userPw
			};

			$.ajax({
				url : "/login",
				type : "post",
				data : JSON.stringify(userData),
				dataType : "json",
				contentType : "application/json",
				success : function(result) {
					if (result == 0) {
						alert("아이디와 비밀번호를 다시 확인해주세요");
						return false;
					} else if (result == 9) {
						alert("통신 오류");
						return false;
					} else {
						window.location.href = "/main";
					}
				},
				error : function(errorThrown) {
					alert(errorThrown.statusText);
				}
			});
		}
	</script>
</body>
</html>
