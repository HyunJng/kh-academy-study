package p01.using_generics;

// <String> : T를 String으로 고정.
// -> JVM이 실행할 때 Box<String>에 대한 클래스를 만들어 놓음
// -> Box<Apple>, Box<Integer> 도 JVM이 실행할 별도로 클래스를 만들어놓음.
// 단점 : 클래스가 메모리에 여러개 만들어진다.
// 1. compile할 때 data type이 결정되어, 어떠한 data type을 사용하더라도 casting 없이 사용
// 2. generic타입은 class뿐만 아니라 interface, method 에서도 사용이 가능.
public class BoxEx {
	public static void main(String[] args) {
		Box<String> b1 = new Box<String>();
		b1.setT(null);
		b1.setT("hello");
		String str1 = b1.getT();
		
		Box<Apple> a1 = new Box<Apple>();
		a1.setT(new Apple());
		Apple apple = a1.getT();
		
		Box<Integer> i1 = new Box<Integer>();
		i1.setT(10);
		Integer integer = i1.getT();
	}
}
