package p01.basic2;

public class PhoneEx {
	public static void main(String[] args) {
		Phone phone;
		
//		phone = new ApplePhone();
		phone = new LGPhone();
		phone.sendCall();
		phone.recieveCall();
//		phone.flash(); // 이런 식으로는 사용할 일이 없음
		
		
	}
}
