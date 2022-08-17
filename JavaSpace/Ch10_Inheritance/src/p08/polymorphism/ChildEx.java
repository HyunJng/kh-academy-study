package p08.polymorphism;

public class ChildEx {
	public static void main(String[] args) {
		Child child = new Child();
		
		child.method1();	// Parent
		child.method2();	// Child
		child.method3();	// child
		
		System.out.println();
		
		Parent parent = child; // Promotion발생
		
		parent.method1();	//Parent
		parent.method2();	//Child
//		parent.method3();

	}
}
