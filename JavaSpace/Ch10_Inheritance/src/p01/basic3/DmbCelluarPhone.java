package p01.basic3;

public class DmbCelluarPhone extends CelluarPhone{
	int channel;

	public DmbCelluarPhone(String model, String color, int channel) {
		//부모클래스의 필드를 생성자에서 호출 가능.
		this.model = model;
		this.color = color;
		this.channel = channel;
	}
	
	void turnOnDmb() {
		System.out.println("채널 "+channel + " 번 DMB 방송 수신 시작합니다.");
	}
	
	void changeChannelDmb(int channel) {
		System.out.println("채널 "+ channel + " 번으로 변경합니다.");
	}
	
	void turnOffDmb() {
		System.out.println("방송 수신을 종료합니다.");
	}
	
}
