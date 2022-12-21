package p110.di.constructor;

public class SamsungTV implements TV{
	private SonySpeaker speaker;
	
	public SamsungTV() {
		System.out.println("1. SamsungTV 객체 생성");
	}
	public SamsungTV(SonySpeaker speaker) {
		this.speaker = speaker;		
	}
	public void powerOn() {
		System.out.println("SamsungTV -- 전원 켠다.");
	}

	public void powerOff() {
		System.out.println("SamsungTV --전원 켠다.");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
}
