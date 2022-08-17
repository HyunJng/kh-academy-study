package p11.practice;

public class TestGeometric {
	public static void main(String[] args) {
		Circle circle = new Circle("red", true, 5);
		

		System.out.println("Circle 전체 정보 : "+ circle);
		System.out.println("Circle color : "+ circle.getColor());
		System.out.println("Circle radius : "+ circle.getRadius());
		System.out.println("Circle area : "+ circle.getArea());
		System.out.println("Circle diameter : "+ circle.getDiameter());
		
		System.out.println();
		
		Rectangle rectangle = new Rectangle("yellow", true, 13, 10);
		System.out.println("Rectangle 전체 정보: "+ rectangle);
		System.out.println("Rectangle area : "+ rectangle.getArea());
		System.out.println("Rectangle perimeter : "+ rectangle.getPerimeter());
		
	}
}
