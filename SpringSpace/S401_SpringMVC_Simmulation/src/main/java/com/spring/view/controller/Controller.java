package com.spring.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 원ㄹ ㅐ스프링 MVC에 있는 것
public interface Controller {

	String handleRequest(HttpServletRequest request, HttpServletResponse response);
	
}
