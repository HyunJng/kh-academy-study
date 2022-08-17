package p03.method_override2;

public class Rect extends Shape {

	String name = "Rect";

	@Override
	public void draw() {
		System.out.println("name: "+ name);
	}
}
