package p401.di.annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Spring에서는 @Component 어노테이션은 거의 사용 안하고, 
// 자식 어노테이션인 @Service, @Controller, @Repository를 사용
// - Controller : Servlet class에 사용
// - Service : SErvice class에서 사용
// - Repository : DAO class에서 사용

// "tv" -> 인스턴스로 생성될 bean이 id
@Component("tv")
public class SamsungTV implements TV{
	
	 @Autowired // speaker로 생성된 인스턴스를 setter
	//@Qualifier("apple") // id를 지정해줌,실제로는 객체 하나만 생성하기 때문에 잘 안씀
	//@Resource(name="sony") // Resource = Autoiwred + Qualifier
	private Speaker speaker;
	
	public SamsungTV() {
		System.out.println("1. SamsungTV 객체 생성");
	}
	
	public SamsungTV(Speaker speaker) {
		System.out.println("1. SamsungTV 객체 생성");
		this.speaker = speaker;		
	}
	
	public void powerOn() {
		System.out.println("SamsungTV -- 전원 켠다.");
	}

	public void powerOff() {
		System.out.println("SamsungTV --전원 끈다.");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
}
