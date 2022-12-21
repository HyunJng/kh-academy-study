$(document).ready(function(){
	$("#frm").submit(function(){
		if ($('input[name=pwPtChk]').val() === 'invalid') {
		    alert("암호를 다시 확인해주세요.");
			return false;
		} else {
			$('input[name=pwPtChk]').val() === 'valid';
		}
		if ($('input[name=pwChk]').val() === 'invalid') {
		    alert("암호를 다시 확인해주세요.");
			return false;
		} else {
			$('input[name=pwChk]').val() === 'valid';
		}
		if ($('input[name=idChk]').val() === 'invalid') {
		    alert("id가 중복되었거나 중복 체크하지 않았습니다.");
			return false;
		} else {
			$('input[name=idChk]').val() === 'valid';
		}
  	});
		
	$("#btn").click(
		function() {
		var url = 'checkID.do?id=' + $('input[name=id]').val();
		$.getJSON(url, function(data) {	
			if (data.id === $('input[name=id]').val()) {
				$("#s1").css({"font-size" : "3px", "color" : "red"});
				$("#s1").html(" <b>중복된 아이디 입니다.</b>");
				$('input[name=idChk]').val("invalid");
			} else {
				$("#s1").css({"font-size" : "3px", "color" : "green"});
				$("#s1").html(" <b>사용 가능한 아이디 입니다.</b>");
				$('input[name=idChk]').val("valid");
			}
		});
	});
			
	$("#password").focus(function() {
		$('input[name=pwPtChk]').val("invalid");
		$('input[name=pwChk]').val("invalid");
	});
			
	$("#password").blur(function() {
		var pwd1 = $("#password").val();
		var url = 'checkPW.do?pwd1=' + pwd1;
		$.getJSON(url, function(data) {	
			if (data.Ch == "true" ) {
				$("#s2").css({"font-size" : "3px", "color" : "green"});
				$("#s2").html(" <b>사용 가능한 비밀번호 입니다.</b>");
				$('input[name=pwPtChk]').val("valid");
			}
			else {
				$("#s2").css({"font-size" : "3px", "color" : "red"});
				$("#s2").html(" <b>비밀번호는 영문자 대/소문자 특수문자, 숫자포함 6~50 글자까지 입니다.</b>");
				$('input[name=pwPtChk]').val("invalid");
			}
		});
	});
			
	$("#pwdch").focus(function() {
		$('input[name=pwChk]').val("invalid");
	});
			
	$("#pwdch").blur(function() {
		var pwd1 = $("#password").val();
		var pwd2 = $("#pwdch").val();
		if (pwd1 === pwd2 ) {
			$("#s3").css({"font-size" : "3px", "color" : "green"});
			$("#s3").html(" <b>사용 가능한 비밀번호 입니다.</b>");
			$('input[name=pwChk]').val("valid");
		} else {
			$("#s3").css({"font-size" : "3px", "color" : "red"});
			$("#s3").html(" <b>비밀번호가 틀립니다.</b>");
			$('input[name=pwChk]').val("invalid");
		}
	});
});