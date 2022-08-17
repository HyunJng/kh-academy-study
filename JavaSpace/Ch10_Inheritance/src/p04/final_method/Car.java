package p04.final_method;

// final : 자식 클래스 만들지 말라는 의미
// - 대표적인 사용 예 : Java Library class
public class Car {
	public int speed = 0;
	
	public void speedUp() {
		speed++;
	}

	public void speedDown() {
		speed--;
	}
	
	// final method : 부모 메서드를 자식 클래스에서 override 선언 불가.
	public final void stop() {
		speed = 0;
	}
	
}
