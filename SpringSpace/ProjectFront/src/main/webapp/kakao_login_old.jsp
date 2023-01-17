<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li onclick="kakaoLogin();"><a href="javascript:void(0)"> <img
				src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg"
				width="222" alt="카카오 로그인 버튼" />
		</a></li>

		<li onclick="kakaoLogout();"><a href="javascript:void(0)"> <span>카카오
					로그아웃</span>
		</a></li>
	</ul>

	<!-- 카카오 스크립트 -->
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script>
		// 발급받은 키로 SDK 초기화
		Kakao.init('b0abeb82c9cbc955b257f0ac94a1c45f');
		// sdk초기화여부판단(되면 true)
		console.log(Kakao.isInitialized()); 
		//카카오로그인
		function kakaoLogin() {
			Kakao.Auth.login({
				success : function(response) {
					Kakao.API.request({
						url : '/v2/user/me',
						success : function(response) {
							console.log(response)
							//alert(response);
		                    //★ 추가 할 것 : 정보 받은 후 진짜 로그인 처리 
						},
						fail : function(error) {
							console.log(error)
						},
					})
				},
				fail : function(error) {
					console.log(error)
				},
			})
		}
		// 카카오 로그아웃
		function withs(){
			if(Kakao.Auto.getAccessToken()){
				Kakao.Auth.logout()
			}
		}
		//카카오 탈퇴 
		function kakaoLogout() {
			// 액세스 토큰이 있는지 확인
			if (Kakao.Auth.getAccessToken()) {
				Kakao.API.request({
					url : '/v1/user/unlink',
					success : function(response) {
						console.log(response)
		                //★ 추가 할 것 : unlink 성공 후 탈퇴처리

					},
					fail : function(error) {
						console.log(error)
					},
				})
				Kakao.Auth.setAccessToken(undefined)
			}
		}
	</script>
	<script type="text/javascript">
		// b0abeb82c9cbc955b257f0ac94a1c45f
	</script>

</body>
</html>