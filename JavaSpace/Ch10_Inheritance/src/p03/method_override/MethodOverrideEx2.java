package p03.method_override;

public class MethodOverrideEx2 {
	
	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.paint();
		
		Line line = new Line();
		line.paint();
		
		Rect rect = new Rect();
		rect.paint();
		
		Circle circle = new Circle();
		circle.paint();
		
		Shape scircle = new Circle();
		scircle.paint();
		
		
		Shape srect = new Rect();
		srect.paint();
		System.out.println(srect.x);
	}
}
