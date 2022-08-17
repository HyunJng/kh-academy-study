package p03.method_override2;

public class MethodOverrideEx {
	
	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.draw();
		
		Line line = new Line();
		line.draw();
		
		Rect rect = new Rect();
		rect.name = "Rect_Name";
		rect.draw();
		
		Circle circle = new Circle();
		circle.draw();
		
		Shape rect_S = new Rect();
		rect_S.draw();
		System.out.println(rect_S.name);
	}
}
