<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<script>
var obj = {"tno": 120, "owner": "kim", "grade": "A"};
function requestBodyTest() {
    $.ajax({
        url: "http://localhost:8000/biz/sample/ticket",
        type: "post",
        data: JSON.stringify(obj),
        dataType: "json",
        contentType: "application/json",
        success: function(data) {
            alert("tno = " + data.tno + ", owner = " + data.owner + ", grade = " + data.grade);
        },
        error: function(errorThrown) {
            alert(errorThrown.statusText);
        }
    });
}
</script>
</head>
<body>
	<button onclick="requestBodyTest()" type="button">RequestBodyTest</button>
</body>
</html>