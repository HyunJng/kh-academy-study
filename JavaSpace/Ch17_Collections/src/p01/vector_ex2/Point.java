package p01.vector_ex2;

public class Point {
	private int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point temp = (Point)obj;
			return x == temp.x && y == temp.y;
		}
		return false;
	}
}
