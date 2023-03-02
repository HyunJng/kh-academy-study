<%@page import="java.util.List"%>
<%@page import="com.carrot.domain.AttachImageVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
 <title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/order.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/fix/gnb.jsp"></jsp:include>
	
	<div class="container">
		<header>
			<jsp:include page="/WEB-INF/views/fix/header.jsp"></jsp:include>
		</header>
		<div class="page_sub_header">
			<h4>#주문정보</h4>
		</div>
		<div id="order_div" class="row p-1">
			<div id="left_div" class="rounded-3 col-8 mx-3">
				<!-- 회원 정보 -->
				<div class="info_div">
					<table class="table table-borderless">
						<tr>
							<th>주문자</th>
							<td>${memberInfo.memberName} | ${memberInfo.memberEmail}</td>
						</tr>
					</table>
				</div>
				<!-- 배송지 정보 -->
				<div class="info_div">
					<div>
						<button class="btn address_btn address_btn_1" onclick="showAddress('1');" style="background-color: #696969 !important;">사용자 주소록</button>
						<button class="btn address_btn address_btn_2" onclick="showAddress('2');">직접 입력</button>
					</div>
					<div>
						<div class="address_input_div address_input_div_1" style="display:block;">
							<table class="table">
								<colgroup>
									<col width="25%">
									<col width="*">
								</colgroup>
								<tbody>
									<tr>
										<th>수령인</th>
										<td>${memberInfo.memberName }</td>
									</tr>
									<tr>
										<th rowspan="3"><br>주소</th>
										<td>${memberInfo.memberAddr1}</td>
									</tr>
									<tr>
										<td>${memberInfo.memberAddr2}</td>
									</tr>
									<tr>
										<td>${memberInfo.memberAddr3}</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="address_input_div address_input_div_2">
							<table class="table">
								<colgroup>
									<col width="25%">
									<col width="*">
								</colgroup>
								<tbody>
									<tr>
										<th>수령인</th>
										<td>
											<input class="form-control" type="text" name="addressee">
										</td>
									</tr>
									<tr>
										<th rowspan="3"><br>주소</th>
										<td class="row">
											<div class="col-8">
												<input class="form-control" type="text" name="memberAddr1" readonly>
											</div>
											<div class="col-4">
												<button class="btn btn-secondary" id="address_search_btn">주소 검색</button>
											</div>
										</td>
									</tr>
									<tr>
										<td>
											<input class="form-control" type="text" name="memberAddr2" readonly>
										</td>
									</tr>
									<tr>
										<td>
											<input class="form-control" type="text" name="memberAddr3" readonly>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- 상품 정보 -->
				<div class="info_div">
					<table class="table">
						<colgroup>
							<col width="15%">
							<col width="*%">
							<col width="15%">
							<col width="15%">
						</colgroup>
						<tbody>
							<tr>
								<th>주문상품 </th>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<c:forEach var="item" items="${orderList}">
								<tr>
									<td class="item_info_td">
										<input type="hidden" name="bookCount" value="${item.bookCount}">
										<input type="hidden" name="bookPrice" value="${item.bookPrice}">
										<input type="hidden" name="totalPoint" value="${item.totalPoint}">
										<input type="hidden" name="totalPrice" value="${item.totalPrice}">
										<img alt="책" src="${item.bookImage}" width="90px"/>
									</td>
									<td>${item.bookName}</td>
									<td class="item_count_td">
										${item.bookCount}개
									</td>
									<td class="item_price_td">
										<fmt:formatNumber value="${item.totalPrice}" pattern="##,###원" />
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- 포인트 정보 -->
				<div  class="info_div">
					<table class="table table-borderless">
						<colgroup>
							<col width="25%">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>포인트 사용</th>
								<td>
									${memberInfo.memberPoint} p | <input class="point_input" value="0"> p 
									<button class="btn btn-outline-warning btn-sm point_input_btn point_input_btn_N" data-state="N">모두사용</button>
									<button class="btn btn-outline-warning btn-sm point_input_btn point_input_btn_Y" data-state="Y" style="display: none;">사용취소</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div id="right_div" class="rounded-3 col-3">
				<table class="table">
					<tr>
						<th colspan="2">결제 정보</th>
					</tr>
				</table>
				<table class="table table-borderless">
					<tr>
						<td>상품금액</td>
						<td class="totalbookPrice"></td>
					</tr>
					<tr>
						<td>배송비</td>
						<td class="delivaryPrice"></td>
					</tr>
					<tr>
						<td>할인금액</td>
						<td class="salePrice"></td>
					</tr>
					<tr>
						<td>사용 포인트</td>
						<td class="usePoint"></td>
					</tr>
				</table>
				<table class="table table-borderless border-top">
					<tr>
						<th>최종결제결제</th>
						<th class="finalTotalPrice"></th>
					</tr>
					<tr>
						<td>적립예정포인트</td>
						<td class="totalPoint"></td>
					</tr>
				</table>
				<div class="d-grid">
					<button id="order_btn" class="btn btn-warning btn-block" >결제하기</button>
				</div>
			</div>
		</div>
	</div>
	
	<footer>
		<jsp:include page="/WEB-INF/views/fix/footer.jsp"></jsp:include>
	</footer>
</body>

<script type="text/javascript">
	let limitPoint = 0;
	
	$(function(){
		/* 결제 칸 스크롤 처리 */
		$(window).scroll(function(){
			$('#right_div').css('top',$(window).scrollTop());
		});
		
		/* 총 주문 정보 출력 */
		setTotalInfo();
	});
	
	/* 총 주문 정보 세팅 */
	function setTotalInfo(){
		let totalPrice = 0;
		let totalCount = 0;
		let totalKind = 0;
		let totalbookPrice = 0;
		let totalPoint = 0;
		let deliveryPrice = 0;
		let usePoint = 0;
		let finalTotalPrice = 0;
		
		$(".item_info_td").each(function(index, element){
			totalPrice += parseInt($(element).find("input[name='totalPrice']").val());
			totalCount += parseInt($(element).find("input[name='bookCount']").val());
			totalPoint += parseInt($(element).find("input[name='totalPoint']").val());
			totalbookPrice += parseInt($(element).find("input[name='bookPrice']").val() * $(element).find("input[name='bookCount']").val());
			totalKind += 1;
		});
		
		if(totalPrice >= 20000){
			deliveryPrice = 0;
		} else if(totalPrice == 0){
			deliveryPrice = 0;
		} else {
			deliveryPrice = 3000;
		}
		
		usePoint = $(".point_input").val();
		finalTotalPrice = totalPrice + deliveryPrice - usePoint;
		limitPoint = totalPrice + deliveryPrice;

		$(".totalbookPrice").text(totalbookPrice.toLocaleString() + "원");
		$(".delivaryPrice").text(deliveryPrice.toLocaleString() + "원");
		$(".salePrice").text((totalbookPrice - totalPrice).toLocaleString() + "원");
		$(".usePoint").text((usePoint).toLocaleString() + "P");
		$(".finalTotalPrice").text(finalTotalPrice.toLocaleString() + "원");
		$(".totalPoint").text(totalPoint.toLocaleString() + "P");
	}
	
	
	/* 포인트 입력 */
	$(".point_input").on("propertychange change keyup paste input", function(){
		limitPointFunction(parseInt($(this).val()));
	});
	
	/* 포인트 모두 사용 버튼 */
	$(".point_input_btn").on("click", function(){
		const maxPoint = parseInt("${memberInfo.memberPoint}");

		let state = $(this).data("state");
		
		if(state == 'N'){
			limitPointFunction(parseInt(maxPoint));
			$(".point_input_btn_N").css("display", "none");
			$(".point_input_btn_Y").css("display", "inline-block");
		} else {
			limitPointFunction(parseInt(0));
			$(".point_input_btn_N").css("display", "inline-block");
			$(".point_input_btn_Y").css("display", "none");
		}
	});
	
	/* 포인트 사용 제한 && 총정보 업데이트 */
	function limitPointFunction(inputValue){
		const maxPoint = parseInt("${memberInfo.memberPoint}");
		const pointInput = $(".point_input");
		if(inputValue <= 0){
			pointInput.val(0);
		} else if(inputValue >= maxPoint && maxPoint < limitPoint){
			pointInput.val(maxPoint);
		} else if(inputValue >= limitPoint){
			pointInput.val(limitPoint);
		}
		
		setTotalInfo();
	}
	
	/* 주소입력란 버튼 */
	function showAddress(className){
		$(".address_input_div").css("display", "none");
		$(".address_input_div_" + className).css("display", "block");
		
		$(".address_btn").css("background-color", "#d3d3d3");
		$(".address_btn_" + className).prop("style", 'background-color: #696969 !important');
	}
	
	/* 주소찾기  */
		$('#address_search_btn').click(function(){
			new daum.Postcode({
		        oncomplete: function(data) {
	                var roadAddr = data.roadAddress; // 도로명 주소 변수
	                var extraRoadAddr = ''; // 참고 항목 변수
	                
	                // 참고 주소 형식에 맞게 설정
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraRoadAddr += data.bname;
	                }
	                
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                    extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                 }
	                
	                if(extraRoadAddr !== ''){
	                    extraRoadAddr = ' (' + extraRoadAddr + ')';
	                }
	                
	                // 필드에 넣기
	                $('input[name="memberAddr1"]').val(data.zonecode);
	                $('input[name="memberAddr2"]').val(roadAddr + extraRoadAddr);
	                $('input[name="memberAddr3"]').attr({
	                	"readonly": false,
	                	"placeholder": "상세주소입력"
	                });
	                $('#memberAddr3').focus();
		        }
		    }).open();
		});
</script>
</html>