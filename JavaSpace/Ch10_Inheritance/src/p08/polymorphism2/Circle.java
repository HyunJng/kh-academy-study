package p08.polymorphism2;

public class Circle extends Shape{
	String name;
	
	public Circle(String name) {
		this.name = name;
	}
	@Override
	public void draw() {
		name = "Circle";
		System.out.println("name: "+name);
	}
}
