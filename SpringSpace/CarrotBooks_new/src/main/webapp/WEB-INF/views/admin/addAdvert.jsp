<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/admin/main.css">
<title>Insert title here</title>
 
</head>
<body>
	
	<!-- gnd -->
	<jsp:include page="/WEB-INF/views/fix/gnb.jsp"></jsp:include>
	
	<div class="container">
		<div id="admin_title"class="pt-4 pb-4 ps-3">
			<h1>관리자페이지</h1>
		</div>
		<div class="row mt-2">
			<jsp:include page="/WEB-INF/views/fix/admin_menu.jsp"></jsp:include>
			<div class="col-10">
				<div id="admin_subtitle" class="py-2 ps-2">
					<h4>광고 등록</h4>
				</div>
				<form class="mt-3" action="/admin/manageAdvert/add" method="post">
					<label class="form-label mt-2">광고 이름</label>
					<input class="form-control" type="text" name="advertName" required>
					<label class="form-label mt-2">등록일</label>
					<input class="form-control" type="text" name="regDate" readonly required>
					<label class="form-label mt-2">마감일</label>
					<input class="form-control" type="text" name="endDate" readonly required>
					<label class="form-label mt-2">담당자</label>
					<input class="form-control" type="text" name="uploader" required>
					<label class="form-label mt-2">계약자</label>
					<input class="form-control" type="text" name="company" required>
					<label class="form-label mt-2">관련책</label>
					<input class="form-control" type="text" name="bookId" required>
					<label class="form-label mt-2">이미지</label>
					<input class="form-control" type="file" name="advertImage" required>
				</form>
			</div>
		</div>
	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/fix/footer.jsp"></jsp:include>
	</footer>
</body>

<script type="text/javascript">
	// 파일 서버에 전송(저장)
	$('input[type="file"]').on("change", function(e){
		let formData = new FormData();
		let fileList = $("input[name='advertImage']")[0].files;
		let file = fileList[0];
		
		if(!fileCheck(file.name, file.size)){
			$('input[name="advertImage"]').val("");
			return false;
		}
		
		formData.append("uploadFile", file);
		
		$.ajax({
			url: '/admin/uploadImage',
			processData: false,
			contentType: false,
			data: formData,
			type:'POST',
			dataType:'json',
			success: function(result){
				console.log(result);
			},
			error: function(result){
				alert("이미지 파일이 아닙니다.");
			}
		});
	});
	
	// 입력된 파일 종류 체크
	function fileCheck(fileName, fileSize) {
		let regex = new RegExp("(.*?)\.(jpg|png)$");
		let maxSize = 1048576; //1MB
		
		if(fileSize >= maxSize){
			alert("파일 사이즈 초과");
			return false;
		}
		if(!regex.test(fileName)){
			alert("해당 종류의 파일은 업로드할 수 없습니다.");
			return false;
		}
		return true;
	};
</script>
</html>