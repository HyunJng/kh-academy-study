package p01.basic;

import java.util.Scanner;

// 분모를 0으로 나누면 나오는 에러
// 1. 2개의 정수값을 입력받아, 2개 정수에 대하여 나누기 연산 수행
// 2. 분모로 입력된 정수값이 0이면 Exception 에러가 발생, 강제종료.
public class Quotient {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("2개의 정수를 입력하시오");
			int num1 = scanner.nextInt();
			int num2 = scanner.nextInt();

			try {
				System.out.println(num1 + " / " + num2 + " = " + num1 / num2);
			} catch (ArithmeticException e) {
				System.out.println("다시 입력하시오");
				continue;
			}

			System.out.println("End of program");
			break;
		}
	}
}
