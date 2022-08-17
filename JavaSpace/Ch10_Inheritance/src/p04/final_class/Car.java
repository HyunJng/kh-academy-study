package p04.final_class;

// final : 자식 클래스 만들지 말라는 의미
// - 대표적인 사용 예 : Java Library class
public final class Car {
	public int speed = 0;
	
	public void speedUp() {
		speed++;
	}

	public void speedDown() {
		speed--;
	}
	
	public void stop() {
		speed = 0;
	}
	
}
