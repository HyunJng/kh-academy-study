package q1.make_squareclass;

public class GeometricObject {
	private String color;
	private boolean filled;

	public GeometricObject() {

	}

	public GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}

	public String getColor() {
		return color;
	}

	public boolean isFilled() {
		return filled;
	}
	
	public String toString() {
		return "color: " + color + "\nfilled: " + filled; 
	}
}
