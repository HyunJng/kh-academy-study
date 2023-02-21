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
<title>Insert title here</title>
<style type="text/css">
</style>
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
					<li class="nav-item dropdown">
					  <a class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown">카테고리</a>
					  <ul class="dropdown-menu">
					    <li><a class="dropdown-item" href="#">Link</a></li>
					    <li><a class="dropdown-item" href="#">Another link</a></li>
					    <li><a class="dropdown-item" href="#">A third link</a></li>
					  </ul>
					</li>
					<li class="nav-item"><a class="nav-link active" href="#">베스트</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">신상품</a></li>
					<li class="nav-item"><a class="nav-link" href="#">고객센터</a></li>
				</ul>
			</div>
		</nav>
	</div>
	
</body>
</html>