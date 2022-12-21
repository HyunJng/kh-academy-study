package p022.bean.properties;

public class SamsungTV implements TV{

	public SamsungTV() {
		System.out.println("1. SamsungTV 객체 생성");
	}
	
	public void initMethod() {
		System.out.println("2. 객체의 초기화 작업 수행");
	}
	
	public void destroyMethod() {
		System.out.println("END. 객체의 삭제전 처리할 로직 수행");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV -- 전원 켠다.");
	}

	public void powerOff() {
		System.out.println("SamsungTV --전원 켠다.");
	}

	public void volumeUp() {
		System.out.println("SamsungTV --소리 올린다.");
	}

	public void volumeDown() {
		System.out.println("SamsungTV --소리 내린다.");
	}
}
