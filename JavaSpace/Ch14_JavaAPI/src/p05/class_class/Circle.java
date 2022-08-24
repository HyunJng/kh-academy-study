package p05.class_class;

public class Circle {
	double radius = 1;
	String name = "플레인피자";
	
	public Circle() {}
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public Circle(String name) {
		this.name = name;
	}
	
	public Circle(double radius, String name) {
		this.name = name;
		this.radius = radius;
	}
	
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getRadius() {
		return radius;
	}
	public String getName() {
		return name;
	}
	
	public Double getArea() {
		return radius * radius * Math.PI;
	}
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
}

