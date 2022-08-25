package p01.not_generics;

// 1. Box class 만든 목적
// - 모든 class의 instance를 사용하고 싶어서 object field인 data type을 Object class 선언
// 2. Box class의 한계 및 문제점 : getObject 등을 사용할 때 하상 자식 class로 변환하는 casting이 필요
// 	- 수행시간 소요, 불필요한 promotion, casting을 계속 반복하는 문제 존재
public class BoxEx {
	public static void main(String[] args) {
		Box box = new Box();
		
		box.setObject("홍길동");
		String nameString = (String) box.getObject();
		
		box.setObject(new Apple());
		Apple apple = (Apple) box.getObject();
		
		box.setObject(new Integer(10));
		Integer integer = (Integer) box.getObject();
	}
}	
