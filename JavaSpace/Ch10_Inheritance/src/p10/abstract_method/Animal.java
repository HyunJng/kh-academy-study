package p10.abstract_method;

public abstract class Animal {
	public String kind;
	
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}

	// 추상 메서드(abstract method)
	public abstract void sound();
	
}
