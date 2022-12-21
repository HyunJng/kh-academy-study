package p022.bean.properties;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext022.xml");
		// applicationContext022.xml의 bean 태그에서 사용하는 속성(property) 설명
		// 1. init-method : bean생성시 시작하는 method 선언
		// 2. destroy-method : bean이 삭제되기 전에 실행하는  method 선언
		// 3. lazy-init : true로 지정하면 getBean할 떄, 즉 실제로 bean이 필요한 시점에 new로 인스턴스 만듬
		TV tv = (TV) factory.getBean("tv");
		
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();
		tv.powerOff();
		
		factory.close();
	}
}
