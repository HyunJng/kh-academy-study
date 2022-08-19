package p08.practice1;

// SmartPhone class
// 부모 class: PDA
// 부모 interface : PhoneInterface, MP3Interface
public class SmartPhone extends PDA implements PhoneInterface, MP3Intrface, MobilePhoneInterface{

	@Override
	public void play() {
		System.out.println("음악을 재생합니다.");
	}

	@Override
	public void stop() {
		System.out.println("음악 연주 중단합니다.");
	}

	@Override
	public void sendCall() {
		System.out.println("따르릉 따르릉~~");
	}

	@Override
	public void recieveCall() {
		System.out.println("전화 왔어요~");
	}

	@Override
	public void sendSNS() {
		System.out.println("문자 보냅니다.");
	}

	@Override
	public void receiveSNS() {
		System.out.println("문자 받습니다.");
	}
	
	public void schedule() {
		System.out.println("일정관리 합니다.");
	}
}
