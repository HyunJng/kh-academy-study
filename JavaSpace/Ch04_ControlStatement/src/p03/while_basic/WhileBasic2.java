package p03.while_basic;

public class WhileBasic2 {
	public static void main(String[] args) {
		int sum = 0;
		int number = 1;

		while (number <= 10) {
			sum += number;
			number++;
		}
		System.out.println("0 ~ 10까지의 합 = " + sum);
	}
}
