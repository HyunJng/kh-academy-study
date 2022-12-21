<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
</head>
<body>
	<div class="card mb-4">
		<img class="card-img-top" src="upload/${goods.goods_img }" alt="..." />
		<div class="card-body">
			<div class="small text-muted">${goods.reg_date }</div>
			<h2 class="card-title h4">${goods.goods }</h2>
			<p class="card-text">${goods.goods_info }</p>
			<p class="card-text">${goods.cost }원</p>
			<input name="userID" type="hidden" value="${user.id }">
			
			<input name="seq" type="hidden" value="${goods.seq }">
			<label>구매할 갯수</label>
			<input type = "number" name = "count" required>
			<button class="btn btn-primary" id="btn1" type = "submit">장바구니에 담기</button>
			<button class="btn btn-primary" id="btn2"  type = "submit">바로 구매하기</button>
		</div>
	</div>
		<script type="text/javascript">

		$("#btn2").click(function() {
			
			var url = 'BuyArticle.do?seq=' + $('input[name=seq]').val()+"&count="+$('input[name=count]').val()+"&id="+$('input[name=userID]').val();
			location.href = url;
			
		
	});
$("#btn1").click(function() {
			
			var url = 'CartAdd.do?seq=' + $('input[name=seq]').val()+"&id="+$('input[name=userID]').val()+"&count="+$('input[name=count]').val();
			location.href = url;
			
		
	});
		
		</script>
</body>
</html>