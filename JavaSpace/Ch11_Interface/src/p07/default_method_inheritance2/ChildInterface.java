package p07.default_method_inheritance2;

// 부모Interface의 method1(), method2()를 모두 상속 받음.
public interface ChildInterface extends ParentInterface{
	
	void method3();
	
	void method2();	/// default메소드를 추상 메서드로 override할 수 있다.
}
