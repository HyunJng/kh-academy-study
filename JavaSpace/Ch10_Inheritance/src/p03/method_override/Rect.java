package p03.method_override;

public class Rect extends Shape{
	int x = 3;
	@Override
	public void draw() {
		System.out.println("Rect class - draw()");
	}
}
