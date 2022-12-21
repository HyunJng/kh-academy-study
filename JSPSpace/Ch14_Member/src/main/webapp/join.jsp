<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<style type="text/css">
	li {
		list-style-type:none;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입</h1>
	<p>"*"표시 항목은 필수 입력 항목입니다.</p>
	
	<form action="join.do" method="post">
		<ul>
			<li>이름* <input type="text" name="username" required></li> 
			<li>아이디* <input type="text" name="userid" id="userid" required> <button type="button" id="check_id">중복체크</button> </li>
			<li>비밀번호* <input type="text" name="password" id="pwd" required></li>
			<li>비밀번호 확인* <input type="text" id="check_pwd" required></li>
			<li>이메일 <input type="text" name="email"></li>
			<li>전화번호<input type="text" name="tel"></li>
			<li>등급 
				<label><input type="radio" name="level" value="user" checked>일반회원</label> 
				<label><input type="radio" name="level" value="admin" >관리자</label>
			</li>
			<li>
				<input type="submit" value="확인" id="join"> 
				<button button="button" onclick="location.href='login.html'">취소</button>
			</li>
		</ul>
	</form>
	
	<script type="text/javascript">
		$(function(){
			var checkId = false;
			
			// submit 눌렀을 때
			$('#join').click(function(){
				var password = $('#pwd').val();
				var chkPassword = $('#check_pwd').val();
				
				// 아이디 중복확인 했는지 확인
				if(checkId != true){
					alert("아이디 중복체크를 해주세요");
					$('#userid').focus();
					return false;
				}
				
				// 비밀번호 확인			
				if(password === chkPassword){
					return true;
				} else {
					alert("비밀번호를 다시 확인하세요.");
					$('#check_pwd').focus();
				}
				return false;
			});
			
			// id 중복 확인
			$('#check_id').click(function(){
				var id = $("#userid").val();
				
 				//$.get('checkid.do?userid='+ id, function(isUser){
				$.post('checkid.do', {userid: id},function(isUser){
					if(isUser=="false"){
						alert('사용 가능한 아이디입니다.');
						checkId = true;
					} else{
						alert('이미 존재하는 아이디입니다.');
						$('#userid').focus();
						return false;
					}
				});
			});
		});
	</script>
</body>
</html>