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
		<div class="mb-3 mt-3 py-3 ps-3" id="title">
			<h1>회원가입</h1>
		</div>
		<form class="" action="/member/join" method="post" onsubmit="return submitForm();">
			<div class="mb-3 mt-3">
				<label class="form-label">이메일</label>
				<div class="row">
					<div class="col-10">
						<input class="form-control" id="memberEmail" type="email" name="memberEmail" required>
					</div>
					<div class="col-2">
						<button class="btn btn-outline-secondary" id="email_dupl" type="button">중복확인</button>
					</div>
				</div>
				<div>
					<span id="email_dul_check"></span>
				</div>
				<div class="row  mt-3">
					<div class="col-8">
						<input class="form-control" id="mail_auth_check" type="text" disabled>
					</div>
					<div class="col-4">
						<button class="btn btn-outline-secondary" id="email_check_btn" type="button">인증번호 전송</button>
					</div>
				</div>
				<div>
					<span id="email_input_alert"></span>
				</div>
			</div>
			<div class="mb-3">
				<label class="form-label">비밀번호</label>
				<input class="form-control" type="text" id="pw" name="memberPw" required>
			</div>
			<div class="mb-3">
				<label class="form-label">비밀번호 확인</label>
				<input class="form-control" id="pw_re"type="text" autocomplete="off">
				<span id="pw_check"></span>
			</div>
			<div class="mb-3">
				<label class="form-label">이름</label>
				<input class="form-control" type="text" name="memberName">
			</div>
			<div class="mb-3">
				<label class="form-label">주소</label>
				<div class="row">
					<div class="col-10">
						<input class="form-control" type="text" id="memberAddr1" name="memberAddr1" readonly>
					</div>
					<div class="col-2">
						<button class="btn btn-outline-secondary" id="find_addr_btn" type="button">주소 찾기</button>
					</div>
				</div>
			</div>
			<div class="mb-3">
				<input class="form-control" type="text" id="memberAddr2" name="memberAddr2" readonly>
			</div>
			<div class="mb-3">
				<input class="form-control" type="text" id="memberAddr3" name="memberAddr3" readonly>
			</div>

			<div id="join_btn" class="d-flex flex-row-reverse">
				<button class="btn" id="submit" type="submit">회원가입</button>
				<button class="btn btn-light mx-2"type="button" onclick="history.go(-1)">돌아가기</button>
			</div>
		</form>
	</div>
</body>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
		var checkNum; // 인증번호
		
		/* 유효성 검사 통과 유무  변수*/
		var emailDuplCheck = false; // 이메일 중복 검사
		var emailAuthCheck = false; // 이메일 인증 검사
		var pwReCheck = false; // 비밀번호 확인 검사
		
		/* 이메일 중복 확인  */
		$('#email_dupl').on("click", function(){
			var memberEmail = $('#memberEmail').val();

			$.ajax({
				url: "/member/emailDuplChk",
				type:"post",
				data: {'memberEmail': memberEmail},
				success: function(result){
					console.log("중복확인: " + result);
					if(result == 'success'){
						$('#email_dul_check').attr("class", "email_input_true");
						$('#email_dul_check').html("사용 가능한 이메일입니다.");
						emailDuplCheck = true;
					}else {
						$('#email_dul_check').attr('class', 'email_input_false');
						$('#email_dul_check').html("이미 사용중인 이메일입니다.");
						emailDuplCheck = false;
					}
				},
				error: function(errorThrown){
					alert(errorThrown.statusText);
				}
			});			
		});
		
		/* 확인 메일 보내기 */
		$('#email_check_btn').click(function(){
			
			var memberEmail = $('#memberEmail').val();
			
			$.ajax({
				url: "/member/emailAuthChk?memberEmail=" + memberEmail,
				type:"get",
				success: function(result){
					console.log("인증여부:" + result);
					$('#mail_auth_check').attr('disabled', false);
					checkNum = result;
				},
				error: function(errorThrown){
					alert(errorThrown.statusText);
				}
			});
		});
		
		/* 인증번호 비교 */
		$('#mail_auth_check').blur(function(){
			var inputNum = $('#mail_auth_check').val();
			var alertElement= $('#email_input_alert');

			console.log(inputNum == checkNum);

			if(inputNum == checkNum){
				alertElement.html("인증번호가 일치합니다.");
				alertElement.attr("class", "email_input_true");
				emailAuthCheck = true;
			}else {
				alertElement.html("인증번호를 다시 확인해주세요.");
				alertElement.attr("class", "email_input_false");
				emailAuthCheck = false;
			}
		});
		
		/* 주소 API 사용 */
		$('#find_addr_btn').click(function(){
			new daum.Postcode({
		        oncomplete: function(data) {
	                var roadAddr = data.roadAddress; // 도로명 주소 변수
	                var extraRoadAddr = ''; // 참고 항목 변수
	                
	                // 참고 주소 형식에 맞게 설정
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraRoadAddr += data.bname;
	                }
	                
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                    extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                 }
	                
	                if(extraRoadAddr !== ''){
	                    extraRoadAddr = ' (' + extraRoadAddr + ')';
	                }
	                
	                // 필드에 넣기
	                $('#memberAddr1').val(data.zonecode);
	                $('#memberAddr2').val(roadAddr + extraRoadAddr);
	                $('#memberAddr3').attr({
	                	"readonly": false,
	                	"placeholder": "상세주소입력"
	                });
	                $('#memberAddr3').focus();
		        }
		    }).open();
		});
		
		/* 비밀번호 확인 */
		$('#pw_re').blur(function(){
			var pw = $('#pw').val();
			var pwRe = $('#pw_re').val();
			
			if(pw == pwRe){
				$('#pw_check').attr("class", "email_input_true");
				$('#pw_check').html("비밀번호가 일치합니다.");
				pwReCheck = true;
			}else{
				$('#pw_check').attr("class", "email_input_false");
				$('#pw_check').html("비밀번호를 다시 확인해주세요.");
				pwReCheck = false;
			}
		});

		/* 조건 검사 후 submit 활성화 */
		function submitForm() {
			if(emailDuplCheck && emailAuthCheck && pwReCheck){
				return true;
			}else {
				if(!emailDuplCheck){
					alert("이메일 중복을 확인해주세요");
					$('#email_dupl').focus();
				}else if(!emailAuthCheck){
					alert("이메일 인증을 해주세요");
					$('#email_check_btn').focus();
				}else if(!pwReCheck){
					alert("비밀번호 확인을 해주세요");
					$('#pw_re').focus();
				}
				
				return false;
			}
			
		}
</script>
</html>