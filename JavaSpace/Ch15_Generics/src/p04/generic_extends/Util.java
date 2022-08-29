package p04.generic_extends;

// <T extends Number>
// 1. T는 Number 본인이나 자식만 가능하다.


public class Util{
	public static <T extends Number> int compare(T t1, T t2) {
		double d1 = t1.doubleValue();
		double d2 = t2.doubleValue();
		
		return Double.compare(d1, d2);
	}
}
