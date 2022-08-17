package p05.prected_acces_modifier.pkg2;

import p05.prected_acces_modifier.pkg1.A;

// 부모 생성자가 protected로 선언된 경우에 자식 class에서 new로 인스턴스 생성 불가
//	>> 대신에 super()을 통해 부모 생성자 호출 가능
// protected 로 선언된 field, method는 자식 클래스에서 사용 가능
public class D extends A{
	
	public D() {
		super(); //부모인 A protected생성자 호출
		this.field = "newValue";
		this.method();
	}
	@Override
	protected void method() {
//		A a = new A();
//		a.field = "newValue";
//		a.method();
	}
}
