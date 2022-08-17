package q01.quiz02;

public class Quiz10 {
	public static void main(String[] args) {

		int sum = 0;

		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0)
				sum += i;
		}

		System.out.println("1 ~ 100 범위 3의 배수의 합은 " + sum);
	}
}
