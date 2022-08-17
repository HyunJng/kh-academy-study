package p02.int_dec;

public class IncrementOperatorEx {
	public static void main(String[] args) {
		int n1 = 10;
		int result;

		System.out.println("n1 = " + n1);
		n1++;
		System.out.println("n1 = " + n1);

		++n1;
		System.out.println("n1 = " + n1);

		result = n1++; // 1. result = n1, 2. result += 1;
		System.out.println("result = " + result);
		System.out.println("n1 = " + n1);

		result = ++n1;	// 1. n1 += 1 , 2. result = n1;

		System.out.println("result = " + result);
		System.out.println("n1 = " + n1);
	}
}
