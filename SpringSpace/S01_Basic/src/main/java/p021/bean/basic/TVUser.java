package p021.bean.basic;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		// applicationConext.xml에 등록된 모든 bean들을 찾아서 Spring이 new로 인스턴스 생성
		// spring에서 bean을 자동 생성할 떄 사용하는 대표적 class들
		// 1) GenericXmlApplicationContext : java 코드 내에서 직접 class르 사용하여 bean을 생성
		// 2) XmlWebApplicationContext : spring이 자동으로 servlet등 class들로 bean을 생성
		// 	=> 일반 개발자가 사용할 수 없는 class
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		TV tv = (TV) factory.getBean("tv");
		
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();
		tv.powerOff();
	}
}
