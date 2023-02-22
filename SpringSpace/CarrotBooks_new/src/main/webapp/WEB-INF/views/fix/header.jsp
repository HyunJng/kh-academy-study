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
.dropbtn {
  background-color: #f7f7f7;
  color: black;
  border:none;
  padding: 0.5rem 0.25rem;
  margin: 0 0.5rem;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: rgba(255,243,224,1.0);
   min-width: 500px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 10;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: inline-block;
  z-index: 20;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}
.dropdown-content:hover{
	display: block;
}
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
					<li class="dropdown">
					  <button class="dropbtn">국내 </button>
					  <div class="dropdown-content">
					  	<c:forEach var="cate" items="${cateList}">
						  	<c:if test="${cate.tier == 3 && cate.cateCode < 200000}">
						    	<a href="/main/search?cateCode=${cate.cateCode}">${cate.cateName}</a>
					  		</c:if>
					  	</c:forEach>
					  </div>
					</li>
					<li class="dropdown">
					  <button class="dropbtn">국외 </button>
					  <div class="dropdown-content">
					  	<c:forEach var="cate" items="${cateList}">
						  	<c:if test="${cate.tier == 3 && cate.cateCode > 200000}">
						    	<a href="/main/search?cateCode=${cate.cateCode}">${cate.cateName}</a>
					  		</c:if>
					  	</c:forEach>
					  </div>
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
<script type="text/javascript">

</script>
</html>