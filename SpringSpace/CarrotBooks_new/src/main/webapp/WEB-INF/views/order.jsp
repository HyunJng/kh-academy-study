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
<style type="text/css">
#order_div {
	text-align: center;
}

#left_div {
	display: inline-block;
	background-color: white;
	margin-top: 5px;
	padding: 0;
}
#right_div {
	display: inline-block;
	border: 1px solid #dcdcdc;
	position: relative;
	height: 400px;
	background-color: white;
}

.info_div {
	border: 1.8px solid #dcdcdc;
	border-radius: .25rem;
	margin-bottom: 1rem;
	padding-top: .3rem;
}
.info_div table {
	margin: .7rem 0;
}
.address_btn{
	width: 49%;
	padding: 0.3rem 0 !important;
	border: 0 !important;
	border-radius: .25rem !important;
	background-color: #d3d3d3 !important;
	color: white !important;
}
.address_input_div {
	display: none;
}

</style>
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
									<td>
										<img alt="책" src="${item.bookImage}" width="90px"/>
									</td>
									<td>${item.bookName}</td>
									<td>${item.bookCount}개</td>
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
									${memberInfo.memberPoint} p | <input class="order_point_input" value="0"> p 
									<button class="btn btn-outline-warning btn-sm point_input_btn point_input_btn_N" data-state="N">모두사용</button>
									<button class="btn btn-outline-warning btn-sm point_input_btn point_input_btn_Y" data-state="Y" style="display: none;">사용취소</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- 종합 정보 -->
				<div  class="info_div">
					
				</div>
				
			</div>
			<div id="right_div" class="rounded-3 col-3">
				
			</div>
		</div>
	</div>
	
	<footer>
		<jsp:include page="/WEB-INF/views/fix/footer.jsp"></jsp:include>
	</footer>
</body>

<script type="text/javascript">
	$(function(){
		/* 결제 칸 스크롤 처리 */
		$(window).scroll(function(){
			$('#right_div').css('top',$(window).scrollTop());
		});
	});
	
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