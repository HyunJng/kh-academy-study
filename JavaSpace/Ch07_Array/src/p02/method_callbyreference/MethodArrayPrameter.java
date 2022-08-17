package p02.method_callbyreference;

// 1. num: call by value 이므로 x가 copy.
// 2. nums[]: call by reference이므로 y의 주소가 copy
public class MethodArrayPrameter {
	public static void main(String[] args) {

		int x = 1;
		int[] y = new int[10];

		for (int i = 0; i < y.length; i++)
			y[i] = 100;

		testArrayPrameter(x, y);

		System.out.println("x = " + x);
		System.out.println("y[0] = " + y[0]);
	}

	public static void testArrayPrameter(int num, int[] nums) {
		num = 1000;
		nums[0] = 3333;
	}
}
