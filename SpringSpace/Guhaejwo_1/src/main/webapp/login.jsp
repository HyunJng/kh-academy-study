<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <script src="jquery-3.4.1.js"></script> 
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
    <section class="login-form">
        
        <div>
            <img class="logo" src="/img/logo.jpg">
        </div>
          
        <form action="">
            <div class="int-area">
                <input type="text" name="id" id="id"
                autocomplete="off" required>
                <label for="id">아이디</label> 
            </div>
            <div class="int-area">
                <input type="password" name="pw" id="pw"
                autocomplete="off" required>
                <label for="pw">패스워드</label>
            </div>
            <div class="btn-area">
                <button id="btn" class="default"
                type="submit">로그인</button>
            </div>
            <div class="btn-area">
                <button id="btn"
                type="button" class="kakao">카카오 로그인</button>
            </div>
            <div class="btn-area">
                <button id="btn"
                type="button" class="facebook">페이스북 로그인</button>
            </div>
        </form>
        <div class="caption">
            <div>
                <input class="remember" type="checkbox" value="remember-id"> ID 기억하기
            </div>
            <div>
                <a href="">비밀번호 찾기</a>
            </div>
            <div>
                <a href="./join.jsp">회원가입</a>
            </div>
        </div>
    </section>

    <script>
        // let id = $('#id');
        // let pw = $('#pw');
        // let btn = $('#btn');

        // $(btn).on('click', function(){
        //     if($(id).val() == ""){
        //         $(id).next('label').addClass('warning');
        //         setTimeout(function(){
        //             $('label').removeClass('warning');
        //         },1500);
        //     }
        //     else if($(pw).val() == ""){
        //         $(pw).next('label').addClass('warning'); 
        //         setTimeout(function(){
        //             $('label').removeClass('warning');
        //         },1500);
        //     }
        // });

        let id = document.querySelector('#id')
        let pw = document.querySelector('#pw')
        let btn = document.querySelector('#btn')

        btn.addEventListener('click', () => {
            if(id.value == "") {
                label = id.nextElementSibling
                label.classList.add('warning')
                setTimeout(() => {
                    label.classList.remove('warning')
                }, 1500)
            } else if(pw.value == "") {
                label = pw.nextElementSibling
                label.classList.add('warning')
                setTimeout(() => {
                    label.classList.remove('warning')
                }, 1500)
            }
        })
    </script>
</body>
</html> 