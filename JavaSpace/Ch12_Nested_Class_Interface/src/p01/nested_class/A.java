package p01.nested_class;

import java.lang.reflect.Field;

public class A {
	
	public A() {
		System.out.println("A 인스턴스 생성");
	}
	
	//instance member class
	class B {
		int field1;
//		static int field2;  // instance member class 에서 static field선언 불가.
		
		public B() {
			System.out.println("B instance member class 인스턴스 생성");
		}
		
		void method1() {
			System.out.println("B class field: " + field1);
		}
//		static method2() {}
	}
	
	// static member class
	static class C{
		int field;
		static int field2;
		
		public C() {
			System.out.println("C static member class 인스턴스 생성");
		}
		
		void method1() {
		System.out.println("C class field: " + field);
		}
		
		static void method2() {
			System.out.println("C class field: " + field2);
		}
		
	}
	// class A의 instance method
	void method() {
		int f1;
		// local class : method 안에 선언된 class
		class D{
			int field1;
//			static int field2
			public D() {
				System.out.println("D static memer class 인스턴스 생성");
			}
			
			void method1() {
				System.out.println("D class field: " + field1);
			}
//			static void method2() {}
		}
		
		D d = new D(); // method내에서 선언된 local class 사용은 method내에서만 가능.
		d.field1 = 3;
		d.method1();
	}
}
