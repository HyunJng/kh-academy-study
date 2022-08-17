package p10.abstract_class;

public class SmartPhoneEx {
	public static void main(String[] args) {
//		Phone phone = new Phone("홍길동"); // 인스턴스 생성 불가
		Phone p = new SmartPhone("홍길동");
		SmartPhone sp = new SmartPhone("홍길동");
		
		p.turnOn();
		p.turnOff();
		
		sp.turnOn();
		sp.internetSearch();
		sp.turnOff();
		
	}
}
