package p01.basic4;

public class MyFunctionalInterfaceEx {
	public static void main(String[] args) {
		MyFunctionalInterface f1;
		
		f1 = (x, y) -> { return x+y; };
		System.out.println(f1.method(5, 1));

		f1 = (x, y) -> x + y;
		System.out.println(f1.method(5, 1));

		f1 = (x, y) -> sum(x, y);
		System.out.println(f1.method(5, 1));
	}

	public static int sum(int x, int y) {
		return x + y;
	}
}
