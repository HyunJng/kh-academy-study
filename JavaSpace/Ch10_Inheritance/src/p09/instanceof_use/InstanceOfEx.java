package p09.instanceof_use;

class Parent {}
class Child extends Parent {}
class Baby extends Parent{}

public class InstanceOfEx {
	public static void main(String[] args) {
		Parent pa = new Child();
		method1(pa);
		method2(pa);
		
		Parent pb= new Child();
		method1(pb);
		method2(pb);
		
		Parent pc = new Baby();
		method1(pc);
		method2(pc);	// error
	}
	// casting할 때 instanceof 꼭 사용할 것
	public static void method1(Parent parent) {
		if(parent instanceof Child) {
			Child child = (Child)parent;
			System.out.println("method1 - Child 인스턴스로 변환성공");
		}else {
			System.out.println("method1 - Child 인스턴스로 변환할 수 없습니다.");
		}
	}
	
	public static void method2(Parent parent) {
		Child child = (Child)parent;
		System.out.println("method2 - Child 인스턴스로 변환 성공");
	}
}
