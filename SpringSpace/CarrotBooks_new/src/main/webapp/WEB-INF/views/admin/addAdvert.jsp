<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/admin/main.css">
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
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
					<div id="uploadResult">
					</div>
					<button class="btn btn-secondary" type="submit">저장</button>
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
		if($("#deleteBtn").length > 0) {
			deleteFile();
		}
		
		let formData = new FormData();
		let fileList = $("input[name='advertImage']")[0].files;
		let file = fileList[0];
		
		// 이미지 파일인지 체크
		if(!fileCheck(file.name, file.size)){
			return false;
		}
		
		formData.append("uploadFile", file);
		
		$.ajax({
			url: '/admin/uploadAdvertImage',
			processData: false,
			contentType: false,
			data: formData,
			type:'POST',
			dataType:'json',
			success: function(result){
				console.log(result);
				showUploadImage(result);
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
	
	// 업로드 이미지 출력
	function showUploadImage(uploadResultArr){
		if(!uploadResultArr || uploadResultArr.length == 0){return};
		
		let uploadResult = $("#uploadResult");
		let obj = uploadResultArr[0];
		let str = "";
 		let fileCallPath = "advert/" + obj.uploadPath.replace(/\\/g, '/')+ "/" + obj.uuid + "_" + obj.fileName; 
		
		str += '<div class="card">';
		str += '<div class="card-header">';
		str += '<button class="btn btn-warning" id="deleteBtn" data-file="'+ fileCallPath +'" type="button">X</button>'
		str += '</div>'
		str += '<div class="card-body">';
		str += '<img alt="업로드이미지" src="/display?fileName='+ fileCallPath +'">';
		str += '</div></div>';
		
		uploadResult.append(str);
	};
	
	// 업로드된 파일 삭제
	function deleteFile(){
		let targetFile = $('#deleteBtn').data("file");
		let targetDiv = $(".card");
		
		$.ajax({
			url: '/deleteFile',
			data : {fileName : targetFile},
			dataType : 'text',
			type : 'POST',
			success : function(result){
				console.log(result);
				targetDiv.remove();
				$('input[name="advertImage"]').val("");
			},
			error : function(result){
				console.log(result);
				alert("파일을 삭제하지 못했습니다.");
			}
       });
	};
	
	// 출력된 이미지 삭제
	$("#uploadResult").on("click", "#deleteBtn", function(e){
		deleteFile();
	});
</script>
</html>