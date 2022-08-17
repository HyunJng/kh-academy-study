package p03.method_override;

public class MethodOverrideEx {
	
	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.draw();
		
		Line line = new Line();
		line.draw();
		
		Rect rect = new Rect();
		rect.draw();
		
		Circle circle = new Circle();
		circle.draw();
		
		Shape scircle = new Circle();
		scircle.draw();
		
		
		Shape srect = new Rect();
		srect.draw();
		System.out.println(srect.x);
	}
}
