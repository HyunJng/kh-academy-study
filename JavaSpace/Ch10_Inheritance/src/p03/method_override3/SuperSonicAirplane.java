package p03.method_override3;

public class SuperSonicAirplane extends Airplane{
	public static final int NORMAL = 1, SUPERSONIC = 2;
	public int flyMode = NORMAL;
	
	@Override 	// Override anotation: compile할 때 error check용
	public void fly() {
		//기본: super.fly() 재사용
		// 자식 클래스의 override된 메서드에서는 변경 내용만 코딩
		if(flyMode == SUPERSONIC) {
			System.out.println("초음속 비행합니다.");
		} else {
			// Override된 부모 메서드를 재사용.
			super.fly();
		}
	}
}
