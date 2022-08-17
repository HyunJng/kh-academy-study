package p08.polymorphism2;

public class Shape {
	
	String name = "Shape";
	public void paint() {
		draw();	// 부모 method를 호출하더라도 자식 클래스에서 override된 메서드가 존재하면, 자식 메서드를 호출한다.
	}
	
	public void draw() {
		System.out.println("name: "+name);
	}
	
	
}		
		