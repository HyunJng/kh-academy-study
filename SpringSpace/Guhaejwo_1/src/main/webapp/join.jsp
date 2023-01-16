<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/css/style.css">
    <script src="jquery-3.4.1.js"></script> 
</head>
<body>
    <section class="login-form">
        
        <div>
            <img class="logo" src="/img/logo.jpg">
            <h1>회원가입</h1>
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
            <div class="int-area">
                <input type="password" name="pwc" id="pwc"
                autocomplete="off" required>
                <label for="pwc">패스워드 확인</label>
            </div>
            <div class="int-area">
                <input type="password" name="pn" id="pn"
                autocomplete="off" required>
                <label for="pn">전화번호</label>
            </div>
            <div class="int-area">
                <input type="password" name="ea" id="ea"
                autocomplete="off" required>
                <label for="ea">이메일</label>
            </div>
            <div class="int-area">
                <input type="password" name="ar" id="ar"
                autocomplete="off" required>
                <label for="ar">주소</label>
            </div>
            <div class="btn-area">
                <button id="btn" class="default"
                type="submit">회원가입</button>
            </div>
           
        </form>
        <div class="caption">
            <div>
                <input class="remember" type="checkbox" value="remember-id"> 회원 약관에 동의합니다.
            </div>
            <div>
                <input class="remember" type="checkbox" value="remember-id"> 개인정보 약관에 동의합니다.
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
            else if(pwc.value == "") {
                label = pwc.nextElementSibling
                label.classList.add('warning')
                setTimeout(() => {
                    label.classList.remove('warning')
                }, 1500)
            }
            else if(pn.value == "") {
                label = pn.nextElementSibling
                label.classList.add('warning')
                setTimeout(() => {
                    label.classList.remove('warning')
                }, 1500)
            }
            else if(ea.value == "") {
                label = ea.nextElementSibling
                label.classList.add('warning')
                setTimeout(() => {
                    label.classList.remove('warning')
                }, 1500)
            }
            else if(ar.value == "") {
                label = ar.nextElementSibling
                label.classList.add('warning')
                setTimeout(() => {
                    label.classList.remove('warning')
                }, 1500)
            }

        })
    </script>
</body>
</html> 