<%@page import="java.util.List"%>
<%@page import="com.carrot.domain.AttachImageVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/main.css">
<link rel="stylesheet" href="/resources/css/fix/header.css">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col-2" id="logo">
			<a href="/main">
				<img class="" alt="logo" src="/resources/image/logo.png" width="100%">
			</a>
		</div>
		<div class="col-7 py-5 px-4">
			<div id="header_div" class="row border border-dark rounded-pill d-flex justify-content-center">
				<form action="/main/search" class="d-flex justify-content-between">
					<select name="type" class="form-select col-2">
						<option value="T" selected>제목</option>
						<option value="A">작가</option>
						<option value="N">내용</option>
						<option value="TN">제목+내용</option>
						<option value="P">출판사</option>
					</select> <input class="border border-0 col-6" name="keyword" type="text">
					<button class="btn col-2 border-start">검색</button>
				</form>
			</div>
		</div>
		<div class="col-3"></div>
	</div>
	<div>
		<nav class="navbar navbar-expand-sm bg-light navbar-light">
			<div class="container-fluid">
				<ul class="navbar-nav">

					<li class="dropdown">
					  <button class="dropbtn">국내</button>
					  <div class="dropdown-content" id="cateKorea">
					  </div>
					</li>
					<li class="dropdown">
					  <button class="dropbtn">국외 </button>
					  <div class="dropdown-content" id="cateForeign">
					  </div>
					</li>

					<li class="nav-item"><a class="nav-link active" href="/best">베스트</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">고객센터</a></li>
				</ul>
			</div>
		</nav>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		// 카테고리 추가
		$.ajax({
			url : '/admin/getCateJson',
			type : 'GET',
			dataType : 'json',
			success : function(cateList) {
				let cateForeignArr = new Array(); // 국외
				let cateKoreaArr = new Array(); // 국내
				
				let cateKorea = $("#cateKorea");
				let cateForeign = $("#cateForeign");
				
				for(let i = 0; i<cateList.length; i++){
					if(cateList[i].tier == 3 && cateList[i].cateCode > 200000) {
						let obj = new Object();
						obj.cateName = cateList[i].cateName;
						obj.cateCode = cateList[i].cateCode;
						obj.cateParent = cateList[i].cateParent;
						
						cateForeignArr.push(obj);
					}
					if(cateList[i].tier == 3 && cateList[i].cateCode < 200000) {
						let obj = new Object();
						obj.cateName = cateList[i].cateName;
						obj.cateCode = cateList[i].cateCode;
						obj.cateParent = cateList[i].cateParent;
						
						cateKoreaArr.push(obj);
					}
				}
				
				for(let i = 0; i<cateForeignArr.length; i++){
					cateForeign.append("<a href='/main/search?cateCode=" + cateForeignArr[i].cateCode + "'>" + cateForeignArr[i].cateName + "</a>");
				}
				for(let i = 0; i<cateKoreaArr.length; i++){
					cateKorea.append("<a href='/main/search?cateCode=" + cateKoreaArr[i].cateCode + "'>" + cateKoreaArr[i].cateName + "</a>");
				}
			}
		});
	})
	
	
</script>
</html>