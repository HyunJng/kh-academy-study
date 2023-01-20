<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 부트스트랩5 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

<!-- 구글 폰트 적용 -->
<link href="https://fonts.googleapis.com">
<link href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">

<title>header</title>
</head>
<body>
  <header>
    <!-- 로고 이미지 -->
    <div class="logo">
      <a href="#"><img src="../../resources/image/logo.png" alt="logo"></a>
      <div id="login">
        <a href="#">로그인</a>
        <a href="#">회원가입</a>
      </div>
    </div>
  
    <nav class="navbar navbar-expand-md py-3">
      <div class="container-fluid">

        <!-- 버튼 테두리 없애기 -->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01"
                aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
          <ul class="navbar-nav" id="nav_menu">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#">About 구해줘!펫즈</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#">공지사항</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#">분양</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#">후원</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#">커뮤니티</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </header>
</body>
</html>