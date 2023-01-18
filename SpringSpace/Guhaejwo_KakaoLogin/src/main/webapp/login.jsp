<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<link rel="stylesheet" href="resources/css/style.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<section class="login-form">
			<div>
				<!-- 로고 -->
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

				<div class="btn-area">
	                <button id="btn-kakao-login" href="kakao/login" type="button" class="kakao">카카오 로그인</button>
	            </div>
	
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
	</div>
		
	<!----------------------- 카카오 로그인용 script  -------------------->
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#btn-kakao-login").click(function(event){
			
			// 사용자 키를 전달, 카카오 로그인 서비스 초기화.
			Kakao.init('b0abeb82c9cbc955b257f0ac94a1c45f');
			// 카카오 로그인 서비스 실행하기 및 사용자 정보 가져오기.
			Kakao.Auth.login({
				success:function(auth){
					Kakao.API.request({
						url: '/v2/user/me',
						success: function(response){
							// 사용자 정보를 가져와서 폼에 추가.
							var account = response.kakao_account;

							var userData_kakao = {
								"userId" : "K" + response.id,
								"userEmail" : account.email,
								"userName" : account.profile.nickname,
								"userImg" :  account.profile.profile_image_url
							};
							$.ajax({
								url : "/login/kakao",
								type : "post",
								data : JSON.stringify(userData_kakao),
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
						}, // kakao.Api.request의 success
						fail: function(error){
							alert("카카오 로그인 처리 중 오류가 발생했습니다.");
						}
					}); // kakao.Api.request
				}, // kakao.Auth.login의 success.
				fail:function(error){
					alert("카카오 로그인 처리 중 오류가 발생했습니다.");
				}
			}); // Kakao.Auth.login 끝
		}) // 클릭이벤트
	})// 카카오로그인 끝.
	</script>
	
	<!------------------- 일반 로그인용 script  ---------------->
	<script type="text/javascript">
		$(function() {
			/* 저장된 아이디 불러오기 */
			var rememberId = localStorage.getItem("saveId")

			if (rememberId != 'N') {
				$('#userId').val(rememberId);
			}
		})
		
		function login() {
			var userId = $('#userId').val();
			var userPw = $('#userPw').val();
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