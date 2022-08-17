package p01.basic;

// 산술연산자(Arithmetic Operator) : + - / * %
public class ArithmaticOperatorEx {
	public static void main(String[] args) {
		int a1 = 10;
		int a2 = 3;
		int result;
		double dresult;

		result = a1 + a2;
		System.out.println("a1 + a2 = " + result);

		result = a1 - a2;
		System.out.println("a1 - a2 = " + result);

		result = a1 * a2;
		System.out.println("a1 * a2 = " + result);

		result = a1 / a2;
		System.out.println("a1 / a2 = " + result);

		result = a1 % a2;
		System.out.println("a1 % a2 = " + result);

		dresult = (double) a1 / a2;
		System.out.println("a1 % a2 = " + dresult);		
		
	}
}
