<%@page import="USER.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Home</title>
           <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="http://code.jquery.com/jquery-3.1.1.js"></script>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	 
        <!-- Favicon-->
        <link rel="stylesheet" href="css/login.css">
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
      </head>
    <body>
        <!-- Responsive navbar-->
     <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="getGoodsList.do">Welcome Shop</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                	  
                     <input type = "hidden" name = "WRole" value = "${user.role }">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                   		
                        <li class="nav-item"><a href="getUserInfo.do?id=${user.id}&WRole=${user.role}"  class="nav-link">마이 페이지</a></li>
                        <li class="nav-item" id = "forSeller"><a class="nav-link" href="uploadArticle.jsp">물품 등록</a></li>
                        <li class="nav-item" id = "forSeller"><a class="nav-link" href="logout.do">로그 아웃</a></li>
                       	
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Page header with logo and tagline-->
        <header class="py-5 bg-light border-bottom mb-4">
            <div class="container">
                <div class="text-center my-5">
                    <c:choose>  
	<c:when test="${user.role eq '판매자'}"> 
	 <h1 class="fw-bolder">판매 상품</h1>
	</c:when> 
	<c:otherwise> 
		  <h1 class="fw-bolder">구매 상품</h1>
	</c:otherwise> 
</c:choose>  
                   
                </div>
            </div>
        </header>
         <!-- Page content-->
        <div class="container">
            <div class="row">
            <c:choose>
            <c:when test="${user.role eq '구매자' }">
            <c:choose>  
	<c:when test="${count == 0}"> 
	<div class="col-lg-8">


		<!-- Nested row for non-featured blog posts-->
	<h1>상품이 존재하지 않습니다</h1>
	<a class="btn btn-primary" href="getGoodsList.do">돌아가기</a>
			 </div>
	</c:when> 
	<c:otherwise> 
		 <jsp:include page="MyGoods.jsp"/>
	</c:otherwise> 
</c:choose>  
</c:when>
<c:otherwise>
	<c:choose>  
	<c:when test="${count == 0}"> 
	<div class="col-lg-8">


		
	<h1>상품이 존재하지 않습니다</h1>
	<a class="btn btn-primary" href="getGoodsList.do">돌아가기</a>
			 </div>
	</c:when> 
	<c:otherwise> 
		 <jsp:include page="sellGoods.jsp"/>
	</c:otherwise> 
</c:choose>  
</c:otherwise>
</c:choose>
                <!-- Blog entries-->
              
                <!-- Side widgets-->
                <div class="col-lg-4">
                    <!-- Search widget-->
                <jsp:include page="userInfo.jsp"/>
                    <!-- Categories widget-->
                    <div class="card mb-4">
                        <div class="card-header">Categories</div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-6">
                                    <ul class="list-unstyled mb-0">
                                        <li><a href="#!">Web Design</a></li>
                                        <li><a href="#!">HTML</a></li>
                                        <li><a href="#!">Freebies</a></li>
                                    </ul>
                                </div>
                                <div class="col-sm-6">
                                    <ul class="list-unstyled mb-0">
                                        <li><a href="#!">JavaScript</a></li>
                                        <li><a href="#!">CSS</a></li>
                                        <li><a href="#!">Tutorials</a></li>
                                    </ul>
                                </div>
                                
                            </div>
                        </div>
                    </div>
                  
                </div>
            </div>
        </div>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script type="text/javascript">
        $(document).ready(function(){
        	
        	if($('input[name=WRole]').val() == '구매자'){
        		$('#forSeller').css("display","none");
        		return false;
        	}
        	
        		
          	});
       	</script>
    </body>
</html>
