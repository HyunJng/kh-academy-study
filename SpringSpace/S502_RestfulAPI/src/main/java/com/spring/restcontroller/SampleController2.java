package com.spring.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/sample2")
public class SampleController2 {

	@RequestMapping("/hello") // 실제 path: /sample2/hello
	String sayHello() {
		return "hello, World";
	}
}