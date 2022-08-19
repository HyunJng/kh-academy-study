package p07.default_method_inheritance;

public class ChildInterfaceEx {
	public static void main(String[] args) {
		ChildInterface ci = new ChildInterface() {
			
			@Override
			public void method1() {
				System.out.println("Anony method1실행");
			}
			
			@Override
			public void method3() {
				System.out.println("Anony method3실행");
			}
			
			@Override
			public void method2() {	// default이므로 꼭 override하지 않아도 된다.
				System.out.println("Anony method2실행");
			}
		};
		
		ci.method1();
		ci.method2();
		ci.method3();
	}
}
