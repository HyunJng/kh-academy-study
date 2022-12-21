package p401.di.annotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		// applicationContext401.xml에서 
		// 1. <context:component-scan> 태그를 사용하여 bean으로 자동 생성할 package이름을 지정한다.
		// 	- package내에 있는 @Component 지정된 class들에 대하여 bean으로 자동 생성하겠다는 의미.
		//	- 폴더로 지정하여 내부의 여러 패키지들이 한꺼번에 해당하도록 만들 수도 있다.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext401.xml");
		// @component 중에서 id가 "tv"인 bean을 가져온다.
		TV tv = (TV) factory.getBean("tv");
		
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();
		tv.powerOff();
		
		factory.close();
	}
}
