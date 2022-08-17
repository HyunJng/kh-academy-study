package p06.class_promotion;

class A {}
class B extends A{}
class C extends A{}
class D extends B{}
class E extends C{}

//primitive type : built-in type
// promotion : 직계 부모가 아니라, 모든 조상이 가능(Object class까지)
public class PromotionEx {
	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		
		A a1 = b;
		A a2 = c;
		A a3 = d;
		A a4 = e;
		Object o = a1;
		
		check(a1);
	}
	
	public static void check(A a) {
		if(a instanceof B)
			System.out.print("B");
		if(a instanceof C)
			System.out.print("C");
		if(a instanceof D)
			System.out.print("D");
		if(a instanceof E)
			System.out.print("E");
		System.out.println();
	}
}
