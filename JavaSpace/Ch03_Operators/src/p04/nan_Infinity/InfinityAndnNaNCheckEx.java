package p04.nan_Infinity;

public class InfinityAndnNaNCheckEx {
	public static void main(String[] args) {
		int x = 5;
		double y = 0.0;
		double z;

//		z = x / y;	// Infinity
		z = x % y; // NaN(Not a Number)

		if ((Double.isFinite(z)) || (Double.isNaN(z))) {
			System.out.println("z의 값을 산출할 수 없습니다.");
		} else {
			z = z + 2;
		}
	}
}