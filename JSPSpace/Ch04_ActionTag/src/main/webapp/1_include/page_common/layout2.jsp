<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="400" border="1" cellpading="0" cellspacing="0">
		<tr>
			<td colspan="2">
				<jsp:include page="/1_include/module/top.jsp" />
			</td>
		</tr>
		<tr>
			<td width="100" valign="top">
				<jsp:include page="/1_include/module/left.jsp" />
			</td>
			<td width="300" valign="top">
				2번째 page본문내용
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<jsp:include page="/1_include/module/bottom.jsp"></jsp:include>
			</td>
		</tr>
	
	</table>
</body>
</html>