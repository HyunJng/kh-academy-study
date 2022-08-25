package p01.using_generics;


// <T> : generic data type (<-> specific)
// 1. class 이름 바로 다음에 사용
// 2. T는 class Box 에서 사용하는 data type임(가상의 데이터 타입, 아직 결정되지 않은 데이터 타입)
// 3. T 대신에 어떠한 다른 글자를 사용 가능
// 4. 일반적으로 한 글자이 영문자를 사용.
// 5. Box<T> : Box가 클래스 이름이 아니라 Box<T> 전체가 클래스 이름으로 간주.
public class Box <T>{
	//<String>으로 고정하면
	
	//private String t;
	private T t;
	
	//public void set(String t)
	public void setT(T t) {
		this.t = t;
	}
	// public String get()
	public T getT() {
		return t;
	}
}
