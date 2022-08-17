package p03.while_basic;

public class WhileBasic3 {
	public static void main(String[] args) {
		int evenSum = 0;
		int oddSum = 0;
		int number = 1;
		while (number <= 10) {
			if (number % 2 == 0)
				evenSum += number;
			else
				oddSum += number;
			number++;
		}
		System.out.println("짝수의 합 = " + evenSum);
		System.out.println("홀수의 합 = " + oddSum);
	}
}
