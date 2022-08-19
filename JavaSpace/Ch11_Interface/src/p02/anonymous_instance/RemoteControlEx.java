package p02.anonymous_instance;

// 익명객체 (Anonymous Instance)
// Interface를 implement한 인스턴스를 의미

public class RemoteControlEx {
	public static void main(String[] args) {

		RemoteControl rc;
		// 익명객체
		rc = new RemoteControl() {
			int volume;
			
			@Override
			public void turnoff() {
				System.out.println("Anonymous(익명)객체 - 전원 켭니다.");
			}
			
			@Override
			public void turnOn() {
				System.out.println("Anonymous(익명)객체 - 전원 끕니다.");
			}
			
			@Override
			public void setVolume(int volume) {
				this.volume = volume;
				System.out.println("Anonymous(익명)객체 - volume : "+ this.volume);
			}
		};

		rc.turnOn();	// polymorphism
		rc.setVolume(7);
		rc.turnoff();
	}
}
