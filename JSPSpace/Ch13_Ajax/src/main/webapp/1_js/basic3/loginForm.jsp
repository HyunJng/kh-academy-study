<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>로그인</h3>
	<form action="" name="frm">
		아이디 : <input type="text"  name="userid"><br/>
		비밀번호 : <input type="text" name="passwd"><br/>
		<input type="button" value="로그인" onclick="chk()">
	</form>
	
	<script type="text/javascript">
	function chk(){
		var data = "userid=" + frm.userid.value;
		data += "&";
		data += "passwd=" + frm.passwd.value;
		alert(data);

		var request = new XMLHttpRequest();
		request.onreadystatechange = function(event) {
			if (request.readyState == 4) {
				if (request.status == 200) {
					document.body.innerHTML += request.responseText;
				}
			}
		};
		var url = 'http://localhost:8000/Ch13_Ajax/Login?' + data;
		request.open('GET', url, true);
		request.send();
	}
	</script>
</body>
</html>