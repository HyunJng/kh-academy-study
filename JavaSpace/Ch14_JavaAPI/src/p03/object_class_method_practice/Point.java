package p03.object_class_method_practice;

import java.util.Objects;

public class Point implements Comparable<Point>{
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(obj instanceof Point) {
			Point other = (Point) obj;
			return x == other.x && y == other.y;
		}
		return false;
	}
	
	@Override
	public int compareTo(Point o) {
		return y - o.y;
	}
}
