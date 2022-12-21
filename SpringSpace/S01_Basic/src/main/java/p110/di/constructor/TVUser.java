package p110.di.constructor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		
		// 만약 xml없이 순수 java로 한단면
//		SonySpeaker speaker = new SonySpeaker();
//		TV tv = new SamsungTV();
		
		// IoC에서 Constructor를 사용한 dependency injection을 사용
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext110.xml");
		TV tv = (TV) factory.getBean("tv");
		
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();
		tv.powerOff();
		
		factory.close();
	}
}
