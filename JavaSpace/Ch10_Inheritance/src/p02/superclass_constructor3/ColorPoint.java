package p02.superclass_constructor3;

public class ColorPoint extends Point {
	private String color;
	
	public ColorPoint() {
		
	}
	public ColorPoint(int x, int y) {
		this(x, y, "Null");
	}
	public ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public void setColorAndPoint(String color, int x, int y) {
		this.color = color;
		this.x = x;	// super.x = x 와 동일. 자식에 동일한 field가 없기 때문.
		this.y = y;
	}

	public void showColorPoint() {
		System.out.print("color : " + color + ",");
		showPoint();
	}
}
