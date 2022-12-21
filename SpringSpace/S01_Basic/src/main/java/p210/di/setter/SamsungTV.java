package p210.di.setter;

public class SamsungTV implements TV{
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("1. SamsungTV 객체 생성");
	}
	
	public SamsungTV(Speaker speaker) {
		System.out.println("1. SamsungTV 객체 생성");
		this.speaker = speaker;		
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("1. SamsungTV 객체 생성");
		this.speaker = speaker;		
		this.price = price;
	}

	public void powerOn() {
		System.out.println("SamsungTV -- 전원 켠다.");
		System.out.println("price : " + this.price);
	}

	public void powerOff() {
		System.out.println("SamsungTV --전원 끈다.");
		System.out.println("price : " + this.price);
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}

	////////// getter/setter
	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("==> setSpeaker() 호출");
		this.speaker = speaker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		System.out.println("==> setPrice() 호출");
		this.price = price;
	}
	
}
