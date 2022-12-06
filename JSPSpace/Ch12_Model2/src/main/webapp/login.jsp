<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
</head>
<body>
<center>
	<h1>로그인</h1>
	<hr>
	<form action="login.do" method="post" id="frm">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td bgcolor="orange">아이디</td>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<td bgcolor="orange">비밀번호</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr colspan="2" align="center">
			<td><input type="submit" value="로그인" id="sm" /></td>
		<tr colspan="2" align="center">
			<td><input type="button" id="btn" value="중복확인" /></td>
		</tr>
		</tr>
	</table>
	</form>
	<input type="hidden" name="idChk" value="invalid" />
</center>
<script type="text/javascript">
$(document).ready(function(){
	$("#frm").submit(function(){
//		alert("submit called");
		if ($('input[name=idChk]').val() === 'invalid') {
		    alert("id가 중복되었거나 중복 체크하지 않았습니다.");
			return false;	// 서버로 전달 X
		}
  	});

	$("#btn").click(function() {
		var url = 'checkID.do?id=' + $('input[name=id]').val();
		$.getJSON(url, function(data) {
			// data = {id:'1111'}
			if (data.id === $('input[name=id]').val()) {
				alert("중복");
				$('input[name=idChk]').val("invalid");
			} else {
				alert("비중복");
				$('input[name=idChk]').val("valid");
			}
		});
	});
	
});



</script>
</body>
</html>