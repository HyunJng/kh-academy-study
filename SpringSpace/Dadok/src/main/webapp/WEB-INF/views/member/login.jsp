<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/member/login.css">
<link rel="stylesheet" href="/resources/css/overall.css">
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>

</head>
<body>
	<div class="container">
		<div class="mb-3 mt-3 py-3 ps-3" id="title">
			<h1>로그인</h1>
		</div>
		<form>
			<div class="mb-3 mt-3">
				<label class="form-label" name="memberEmail">이메일</label>
				<input class="form-control"type="text" placeholder="이메일" name="memberEmail">
			</div>
			<div class="mt-3">
				<label class="form-label">비밀번호</label>
				<input class="form-control" type="password" placeholder="비밀번호" name="memberPw">
			</div>
			<div id="wrong_login" class="text-danger">
				사용자 ID 또는 비밀번호를 잘못 입력했습니다.
			</div>
			<div class="mt-4 d-grid">
				<button class="btn btn-light btn-block" type="submit" onclick="general_login(); return false;">로그인</button>
			</div>
		</form>
	</div>
</body>

<script type="text/javascript">

/* ajax로 굳이 만드는 이유: 로그인 틀렸을 때 입력값이 그대로였으면 해서 */
function general_login(){	
	var memberEmail = $('input[name="memberEmail"]').val();
	var memberPw = $('input[name="memberPw"]').val();
	var loginData = {"memberEmail":memberEmail, "memberPw":memberPw};

	$.ajax({
		url: "/member/login",
		type:"post",
		data: JSON.stringify(loginData),
		dataType:"json",
		contentType:"application/json",
		success: function(result){
			if(result == 0){ // 로그인 실패
				$('#wrong_login').show();
				return false;
			} else { // 로그인 성공
				window.location.href="/main";
			}
		},
		error: function(errorThrown){
			alert(errorThrown.statusText);
		}
	});
};
</script>
</html>