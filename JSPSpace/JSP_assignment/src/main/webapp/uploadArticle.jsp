<%@page import="USER.UserVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<html lang="utf-8">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Home</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="http://code.jquery.com/jquery-3.1.1.js"></script>
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
                    <h1 class="fw-bolder">상품 등록하기</h1>
                    
                </div>
            </div>
        </header>
        <!-- Page content-->
         <div id="layoutSidenav_content">
                <main>
                   <div class="container">
		<div class="row">
			<form method="post" action="insertGoods.do" enctype="multipart/form-data" accept-charset="UTF-8">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align: center;">상품 등록하기</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control" placeholder="상품 이름" name="goods" maxlength="50"></td>
						</tr>
						
						<tr>
							<td><input type="file" name="fileName" size=40 onchange="setThumbnail(event);">
							<tr style="display: flex;justify-content: center;">

								<td id="image_container"></td>
  								 </tr>
    
							
						<tr>
							<td><textarea class="form-control" placeholder="상품 정보" name="goods_info" maxlength="1028" style="height: 150px;"></textarea></td>
						</tr>
						<tr>
						<td>
						 <div class="row">
					            <div class="col-md-6 mb-3">
					              <label for="name">상품 가격</label>
					              <input type="text" class="form-control" id="cost" name = "cost" required>
					             
					            </div>
					            <div class="col-md-6 mb-3">
					              <label for="nickname">상품 재고</label>
					              <input type="text" class="form-control" id="count" name = "count"required>
					           
					            </div>
					          </div>
						</td>
						</tr>
					
					</tbody>
					
				</table>
				<!-- 글쓰기 버튼 생성 -->
				<input type = "hidden" name = "id" value="${user.id }">
				<input type="submit" class="btn btn-primary pull-right" value="상품 등록하기">
				<input type="reset" class="btn btn-primary pull-right" value="상품 취소">
			</form>
		</div>
	</div>	
                   	
                       <div class="messageIcon" onclick="javascript:openChat();"style="cursor:pointer;display:flex; font-size:40px;position:fixed; right:20px; bottom:20px; color:#0d6efd; border" >
              <i class="fas fa-comment-dots"></i>
              </div>
                   
                   
                </main>
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
       	       <script>
	function setThumbnail(event){
		var reader = new FileReader();
		
		reader.onload = function(event){
			var img = document.createElement("img");
			img.setAttribute("src", event.target.result);
			img.setAttribute("class", "col-lg-6");
			img.setAttribute("style","width = 500; var height = 500;");
			document.querySelector("td#image_container").appendChild(img);
		};
		
		reader.readAsDataURL(event.target.files[0]);
	}
	</script>
    </body>
</html>
