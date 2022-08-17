package q01.quiz01;

import java.util.Scanner;

// 0과 1000사이의 3자리 정수를 키보드에서 읽어,
// 정수의 각 자리의 수를 모두 더한 값을 출력하라.

public class Quiz01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("세자리 정수를 한개 입력하시오 : ");
		int num = input.nextInt();
		int sum = 0;

		sum += num % 10;
		num = num / 10;

		sum += num % 10;
		num = num / 10;

		sum += num % 10;

		System.out.println("각 자리 수를 더한 값은 " + sum + "입니다.");

	}
}
