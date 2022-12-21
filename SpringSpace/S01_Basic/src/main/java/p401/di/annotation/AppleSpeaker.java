package p401.di.annotation;

import org.springframework.stereotype.Component;

// id를 부여하지 않으면 스프링이 클래스 이름으로 자동 id이름 생성 (appleSpeaker, sonySpeaker)
//@Component("speaker")
public class AppleSpeaker implements Speaker{
	
	public AppleSpeaker() {
		System.out.println("--> AppleSpeaker 객체 생성");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker --소리 올린다.");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("AppleSpeaker --소리 내린다.");
	}
}
