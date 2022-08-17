package p08.polymorphism2;

public class MethodOverrideEx {

	public static void main(String[] args) {
		Shape[] shapes = new Shape[3];
		shapes[0] = new Line("Line");
		shapes[1] = new Rect("Rect");
		shapes[2] = new Circle("Circle");

		for (int i = 0; i < shapes.length; i++) {
			//shapes[i].draw();
			shapes[i].paint();
		}
	}
}
