<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/admin/main.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script><title>Insert title here</title>
 
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
					<input class="form-control" type="text" name="regDate" autocomplete="off" readonly required>
					<label class="form-label mt-2">마감일</label>
					<input class="form-control" type="text" name="endDate" autocomplete="off" readonly required>
					<label class="form-label mt-2">담당자</label>
					<input class="form-control" type="text" value="${member.memberName}" readonly>
					<input type="hidden" name="uploader" value="${member.memberId}">
					<label class="form-label mt-2">계약자</label>
					<input class="form-control" type="text" name="company" required>
					<label class="form-label mt-2">관련책</label>
					<div class="row">
						<div class="col-9">
							<input id="bookName_input" class="form-control" type="text" readonly>
						</div>
						<input id="bookId_input" name="bookId" type="hidden">
						<button id="bookId_btn" class="btn btn-sm btn-light col-2 ms-2">책 선택</button>
					</div>
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

	// 책 선택 버튼
	$('#bookId_btn').on("click", function(e){
		e.preventDefault();
		let popUrl = "/admin/bookPop";
		let popOption = "width = 650px, height=550px, top=300px, left=300px, scrollbars=yes";
		
		window.open(popUrl, "책 찾기", popOption);
	});
	// 달력 위젯
	$(function(){
		$("input[name='regDate']").datepicker(config);
		$("input[name='endDate']").datepicker(config);
	});
	
	/* 설정 */
	const config = {
		dateFormat: 'yy-mm-dd',
	    prevText: '이전 달',
	    nextText: '다음 달',
	    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    dayNames: ['일','월','화','수','목','금','토'],
	    dayNamesShort: ['일','월','화','수','목','금','토'],
	    dayNamesMin: ['일','월','화','수','목','금','토'],
	    yearSuffix: '년'
	}

	// 파일 서버에 전송(저장)
	$('input[type="file"]').on("change", function(e) {
		if ($("#deleteBtn").length > 0) {
			deleteFile();
		}

		let formData = new FormData();
		let fileList = $("input[name='advertImage']")[0].files;
		let file = fileList[0];

		// 이미지 파일인지 체크
		if (!fileCheck(file.name, file.size)) {
			return false;
		}

		formData.append("uploadFile", file);

		$.ajax({
			url : '/admin/uploadAdvertImage',
			processData : false,
			contentType : false,
			data : formData,
			type : 'POST',
			dataType : 'json',
			success : function(result) {
				console.log(result);
				showUploadImage(result);
			},
			error : function(result) {
				alert("이미지 파일이 아닙니다.");
			}
		});
	});

	// 입력된 파일 종류 체크
	function fileCheck(fileName, fileSize) {
		let regex = new RegExp("(.*?)\.(jpg|png)$");
		let maxSize = 1048576; //1MB

		if (fileSize >= maxSize) {
			alert("파일 사이즈 초과");
			return false;
		}
		if (!regex.test(fileName)) {
			alert("해당 종류의 파일은 업로드할 수 없습니다.");
			return false;
		}
		return true;
	};

	// 업로드 이미지 출력
	function showUploadImage(uploadResultArr) {
		if (!uploadResultArr || uploadResultArr.length == 0) {
			return
		}
		;

		let uploadResult = $("#uploadResult");
		let obj = uploadResultArr[0];
		let str = "";
		let fileCallPath = "advert/" + obj.uploadPath.replace(/\\/g, '/') + "/"
				+ obj.uuid + "_" + obj.fileName;

		str += '<div class="card">';
		str += '<div class="card-header">';
		str += '<button class="btn btn-warning" id="deleteBtn" data-file="'+ fileCallPath +'" type="button">X</button>'
		str += '</div>'
		str += '<div class="card-body d-flex justify-content-center">';
		str += '<img width="400px" alt="업로드이미지" src="/display?fileName=' + fileCallPath+ '">';
		str += '<input type="hidden" name="imageList[0].fileName" value="'+obj.fileName +'">';
		str += '<input type="hidden" name="imageList[0].uuid" value="'+obj.uuid +'">';
		str += '<input type="hidden" name="imageList[0].uploadPath" value="'+obj.uploadPath+'">';
		str += '</div></div>';

		uploadResult.append(str);
	};

	// 업로드된 파일 삭제
	function deleteFile() {
		let targetFile = $('#deleteBtn').data("file");
		let targetDiv = $(".card");

		$.ajax({
			url : '/deleteFile',
			data : {
				fileName : targetFile
			},
			dataType : 'text',
			type : 'POST',
			success : function(result) {
				console.log(result);
				targetDiv.remove();
				$('input[name="advertImage"]').val("");
			},
			error : function(result) {
				console.log(result);
				alert("파일을 삭제하지 못했습니다.");
			}
		});
	};

	// 출력된 이미지 삭제
	$("#uploadResult").on("click", "#deleteBtn", function(e) {
		deleteFile();
	});
</script>
</html>