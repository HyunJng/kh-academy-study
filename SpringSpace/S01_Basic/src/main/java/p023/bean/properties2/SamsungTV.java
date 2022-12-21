package p023.bean.properties2;
// Spring에서 class를 생성할 때 default생성자를 반드시 만드는 것을 권장. 
// -spring 컨테이너가 객체를 생성 관리하기 때문
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
