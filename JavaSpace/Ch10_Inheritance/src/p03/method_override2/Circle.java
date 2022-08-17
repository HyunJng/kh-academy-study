package p03.method_override2;

public class Circle extends Shape{
	String name;
	@Override
	public void draw() {
		name = "Circle";
		super.name = "Shape_New";
		super.draw();
		System.out.println("name: "+name);
	}
}
