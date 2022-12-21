<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	 <script src="http://code.jquery.com/jquery-3.1.1.js"></script>
 
    <!-- 나의 스타일 추가 -->
    <link rel="stylesheet" href="css/login.css">

  </head>
  <body class="text-center">
    
        <div class="card mb-4">
                        <div class="card-header">안녕하세요 ${user.name} 님</div>
                        <div class="card-body">
                            <div class="input-group">
                                <table>
                                	<tr>
										<td >이름</td>
										<td>${user.name }</td>
									</tr>
									<tr>
										<td >아이디</td>
										<td>${user.id }</td>
									</tr>
								
									<tr>
										<td >주소지</td>
										<td>${user.adr }</td>
									</tr>
									<tr>
										<td >email</td>
										<td>${user.email }</td>
									</tr>
									
									<tr>
										<td >전화번호</td>
										<td>${user.tel }</td>
									</tr>
									
								</table>
                            </div>
             <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	 <script src="http://code.jquery.com/jquery-3.1.1.js"></script>
	<button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal" style="width:50%">
			 회원 정보 변경
			</button>
			<button type="button" class="btn btn-secondary" style="width:50%" onclick = "location.href='logout.do'">
			로그아웃
			</button>
			
			<!-- Modal -->
			
				<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
			    <div class="modal-content">
			      <div class="modal-body">
			       <div class="container">
					    <div class="input-form-backgroud row">
					      <div class="input-form col-md-12 mx-auto">
					      <form action="updatetUser.do" class = "validation-form" id = "frm">
					        <h4 class="mb-3">회원 정보수정</h4>
					            <div class="mb-3">
					              <label for="name">아이디</label>
					              <input type="text" class="form-control" value="${user.id }" id="ID" name = "ID" readonly>
					              
					            </div>

					          <div class="row">
					            <div class="col-md-6 mb-3">
					              <label for="name">비밀번호</label>
					              <input type="text" class="form-control" id="pwd1" name = "pwd1" required>
					             
					            </div>
					            <div class="col-md-6 mb-3">
					              <label for="nickname">비밀번호 확인</label>
					              <input type="text" class="form-control" id="pwd2" name = "pwd2"required>
					           
					            </div>
					          </div>
							     <div class="mb-3">
					            <label for="address2">전화번호 </label>
					            <input type="text" class="form-control" id="tel" name = "tel" placeholder="${user.tel }" required>
					          </div>
					          <div class="mb-3">
					            <label for="email">이메일</label>
					            <input type="email" class="form-control" id="email" name = "email"  placeholder="${user.email }" required>
					          
					          </div>
					
					          <div class="mb-3">
					            <label for="address">주소</label>
					            <input type="text" class="form-control" id="address" placeholder="${user.adr }" name = "adr"required>
					            <div class="invalid-feedback">
					              주소를 입력해주세요.
					            </div>
 
					          <hr class="mb-4">
					        
					          <div class="mb-4"></div>
					          <button class="btn btn-primary btn-secondary btn-block" type="submit">수정 완료</button>
					          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
					       		</form>
					      </div>
					    </div>
					    <footer class="my-3 text-center text-small">
					      <p class="mb-1">&copy; 2021 YD</p>
					    </footer>
					  </div>
					   
			      </div>
			      
			    </div>
			  </div>
			 
			</div>
			</form>
	
                        </div>
                        
                    </div>

    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

		<script type="text/javascript">
					$(document).ready(function(){
						$("#frm").submit(function(){
							
							if ($('input[name=idChk]').val() === 'invalid') {
							    alert("id가 중복되었거나 중복 체크하지 않았습니다.");
								return false;
							}
							if($('input[name=pwd1]').val() != $('input[name=pwd2]').val()){
								alert("비밀번호가 서로 다릅니다")
								return false;
							}
							
							
					  	});
					
						$("#btn").click(function() {
							
							var url = 'checkID.do?ID=' + $('input[name=ID]').val();
							$.getJSON(url, function(data) {
								
								if (data.id === $('input[name=ID]').val()) {
									alert("중복");
									$('input[name=idChk]').val("invalid");
								} else {
									alert("비중복");
									$('input[name=idChk]').val("valid");
								}
							});
						});
						
					});
			</script>

  </body>
</html>