package p023.bean.properties2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class TVUser_p {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext023p.xml");
		TV tv = (TV) factory.getBean("tv");
		
		TV tv2 = (TV) factory.getBean("tv");
		
		// applicationContext.xml의 bean에서 scope을 'prototype'으로 지정하면 getBean을 할 때마다 새로운 객체 생성
		if(tv == tv2) {
			System.out.println("tv1과 tv2는 같은 객체입니다.");
		}else {
			System.out.println("tv1과 tv2는 다른 객체입니다.");
		}
		
		factory.close();
	}
}
