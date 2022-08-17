package p01.basic2;

public class Point {
	int x, y;

	public Point() {

	}

	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void showPoint() {
		System.out.println("(" + x + "," + y + ")");
	}

}
