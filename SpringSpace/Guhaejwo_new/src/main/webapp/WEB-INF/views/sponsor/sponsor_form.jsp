<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/resources/css/mypage.css">

<style type="text/css">
* {
	margin: 0;
	padding: 0;
	font-family: 'Noto Sans KR', sans-serif;
	
}

h1 {
	font-size: 35px bold;
}

h2 {
	font-size: 22px bold;
	border-top: 1px solid black;
	border-bottom: 1px solid black;
	padding: 2.4rem;
	margin-bottom: 1.5rem;
}

p {
	font-size: 17px;
}

form {
	float: none;
	margin: 0 auto;
}

.text-end {
  text-align: right !important;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="wrap container">
	
		<jsp:include page="../fix/header.jsp"></jsp:include>
		
		<section>
			<div class="row">
			 	<img class="col-12" src="/resources/image/sponsor/sponsor_content.png">	
				<img class="col-12" src="${sponsor.sponsorItemImg}">
			</div>

			<form class="row justify-content-md-center" action="/sponsor/insert" method="post">
				<h2>굿즈 구매하기</h2>
				
				<!-- 시퀀스들 -->
				<input type="hidden" name="userSeq" value="${login.userSeq}"> <!-- value="${user.userSeq} -->
				<input type="hidden" name="sponsorItemSeq" value="${sponsor.sponsorItemSeq}"> <!-- value="${sponsor.sponsorItemSeq}" -->
				
				<div class="mb-3 col-10">
					<label class="form-label">후원자명</label>
					<input class="form-control"
						 	type="text"
							name="userNaem"
							placeholder="${login.userName}"
							disabled>
				</div>
				<div class="mb-3 col-10">
					<label class="form-label">전화번호</label> 
					<input class="form-control"
							type="text"
							placeholder="${login.userPhone}"
							disabled>
				</div>
				<div class="mb-3 col-10">
					<div class="row">
						<div class="col-xs-4 col-sm-6">
							<label class="form-label">우편번호</label> 
							<input class="form-control"
									type="text"
									id="addr1"
									name="postcode"
									placeholder="우편번호"
									readonly="readonly">					
						</div>
						<div class="col-xs-4 col-sm-6">
							<label class="form-label" style="visibility: hidden;">빈공간</label>
							<input class="form-control btn btn-primary"
									type="button"
									value="우편번호 찾기"
									onclick="excution_addr()">					
						</div>
					</div>
				</div>
				<div class="mb-3 col-10">
					<label class="form-label"></label> 
					<input class="form-control"
							type="text"
							id="addr2"
							name="sponsorShippingAddr"
							value="${login.userAddr}"
							placeholder="주소"
							readonly="readonly">
							<!-- name="addr" -->
				</div>
				<div class="mb-3 col-10">
					<input class="form-control"
							type="text"
							placeholder="상세주소"
							id="addr3"
							name="addrDetail"
							readonly="readonly">
				</div>
				
				<!-- 이메일 필요없으면 지울 것 -->
				<div class="mb-3 col-10">
					<div class="row">
						<div class="col-xs-4 col-sm-6">
							<label class="form-label">이메일</label> 
							<input class="form-control" type="text" placeholder="아이디">
						</div>
						
						<div class="col-xs-4 col-sm-6">
							<label class="form-label" style="visibility: hidden;">빈공간</label>
							<select class="form-control" name="email_tail">
								<option value="@naver.com">naver.com</option>
								<option value="@daum.com">daum.com</option>
								<option value="@nate.com">nate.com</option>
							</select>
						</div>
					</div>
				</div>				
				<div class="mb-3 col-10">
					<label class="form-label">수량</label> 
					<input class="form-control"
							id="amount"
							name="sponsorAmount"
							type="number"
							min="1"
							max="100"
							value="1">
				</div>
				<div class="mb-3 col-10 form-check">
					<input type="checkbox" class="form-check-input">
					<label class="form-check-label" for="exampleCheck1">구매정보 확인했습니다.</label>
				</div>
				<div class="mb-3 col-10 text-end" id="totalPrice">
					<span class="">총 후원가격</span>
					<input type="hidden" id="price" value="${sponsor.sponsorItemPrice}">
					<input class="form-control" type="text" id="total" name="sponsorTotalPrice" value="0" readonly="readonly">
				</div>
				<button type="submit" class="btn btn-primary col-10">Submit</button>
			</form>
		</section>
		
		<jsp:include page="../fix/footer.jsp"></jsp:include>
	</div>
	
	<script type="text/javascript">
	
	// 상품 갯수 * 상품 가격 = 총 가격
	// 이거 수정해야함
	$(function () {
		let amount = $("#amount").val();
		let price = $("#price").val();
		let total = amount * price;
		$("#total").val(total);
	})
	</script>
	
	<!---------------- 주소 api ----------------->
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	// 주소 api
	function excution_addr(){

	      new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수

	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }

	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 주소변수 문자열과 참고항목 문자열 합치기
	                    addr += extraAddr;

	                  } else {
	                    addr += " ";
	                  }

	                $("#addr1").val(data.zonecode);
	                $("#addr2").val(addr);
	                $("#addr3").attr("readonly", false);
	                $("#addr3").focus();
	            }
	        }).open();
	    }
	</script>
</body>
</html>