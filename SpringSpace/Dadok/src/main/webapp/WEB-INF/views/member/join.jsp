<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/member/join.css">
<link rel="stylesheet" href="/resources/css/overall.css">
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>

</head>
<body>
	<div class="container">
		<div class="mb-3 mt-3">
			<h1>회원가입</h1>
		</div>
		<form class="" action="/member/join" method="post">
			<div class="mb-3 mt-3">
				<label class="form-label">이메일</label>
				<div class="row">
					<div class="col-10">
						<input class="form-control" id="memberEmail" type="text" name="memberEmail">
					</div>
					<div class="col-2">
						<button class="btn btn-outline-secondary" id="email_dupl" type="button">중복확인</button>
					</div>
				</div>
				<div>
					<span id="email_input_re1">사용 가능한 이메일입니다.</span>
					<span id="email_input_re2">이미 가입된 회원입니다.</span>
				</div>
				<div class="row  mt-3">
					<div class="col-8">
						<input class="form-control" id="memberEmail" type="text" name="memberEmail" disabled>
					</div>
					<div class="col-4">
						<button class="btn btn-outline-secondary" type="button">인증번호 전송</button>
					</div>
				</div>
			</div>
			<div class="mb-3">
				<label class="form-label">비밀번호</label>
				<input class="form-control" type="text" name="memberPw">
			</div>
			<div class="mb-3">
				<label class="form-label">비밀번호 확인</label>
				<input class="form-control" type="text">
			</div>
			<div class="mb-3">
				<label class="form-label">이름</label>
				<input class="form-control" type="text" name="memberName">
			</div>
			<div class="mb-3">
				<label class="form-label">주소1</label>
				<div class="row">
					<div class="col-10">
						<input class="form-control" type="text" name="memberAddr1">
					</div>
					<div class="col-2">
						<button class="btn btn-outline-secondary"type="button">주소 찾기</button>
					</div>
				</div>
			</div>
			<div class="mb-3">
				주소2
				<input class="form-control" type="text" name="memberAddr2">
			</div>
			<div class="mb-3">
				주소3
				<input class="form-control" type="text" name="memberAddr3">
			</div>
			<div>
				<input class="form-control" type="text" name="memberCk" value="USER" style="display:none">
			</div>
			<div>
				<input type="text" name="loginType" value="GENERAL" style="display:none">
			</div>
			<div id="join_btn" class="d-flex flex-row-reverse">
				<button class="btn btn-primary" type="submit">회원가입</button>
			</div>
		</form>
	</div>
</body>

<script type="text/javascript">
		$('#email_dupl').on("click", function(){
			var memberEmail = $('#memberEmail').val();

			$.ajax({
				url: "/member/memberEmailChk",
				type:"post",
				data: {'memberEmail': memberEmail},
				success: function(result){
					console.log("성공여부" + result);
					if(result == 'success'){
						$('#email_input_re1').css('display', 'inline-block');
						$('#email_input_re2').css('display', 'none');
					}else {
						$('#email_input_re1').css('display', 'none');
						$('#email_input_re2').css('display', 'inline-block');
					}
				},
				error: function(errorThrown){
					alert(errorThrown.statusText);
				}
			});			
		});// function 종료
</script>
</html>