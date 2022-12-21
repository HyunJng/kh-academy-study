package p401.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("lg")
public class LgTV implements TV{
	//@Autowired
	private Speaker speaker;
	
	public void powerOn() {
		System.out.println("LgTV -- 전원 켠다.");
	}

	public void powerOff() {
		System.out.println("LgTV --전원 켠다.");
	}

	public void volumeUp() {
		System.out.println("LgTV --소리 올린다.");
	}

	public void volumeDown() {
		System.out.println("LgTV --소리 내린다.");
	}

}
