package p11.practice2;

public class Circle extends GeometricObject{
	private double radius;

	public Circle() {
		
	}
	public Circle(double radius) {
		this.radius =radius;
	}
	
	public Circle(String color, boolean filled, double radius) {
		super(color, filled);
		this.radius =radius;
	}
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	// 원의 면적
	public double getArea() {
		return (Math.PI * radius * radius);
	}
	// 원의 지름
	public double getDiameter() {
		return 2*radius;
	}
	// 원의 둘레
	public double getPerimeter() {
		return (2 * Math.PI * radius);
	}
	
	public void printCircle() {
		System.out.println("Circle createdDate : " + getDateCreated() + ", radius : "+ radius);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", radius : " + radius;
	}
}
