package p07.break_continue;

public class ContinueEx {
	public static void main(String[] args) {
		int sum = 0;

		// 1 ~ 10 사이의 짝수의 합
		for (int i = 0; i <= 10; i++) {
			if (i % 2 == 1)
				continue;
			sum += i;
		}

		System.out.println("1 ~ 10 사이의 짝수의 합 : " + sum);
	}
}
