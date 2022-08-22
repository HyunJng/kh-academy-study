package p01.basic;

import java.util.Scanner;

public class QuotientWithMethod {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("2개의 정수를 입력하시오.");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		quotient(num1, num2);
		
		System.out.println("end of program");
	}

	public static int quotient(int num1, int num2) {
		if (num2 == 0) {
			System.out.println("분모에 0을 사용할 수 없습니다.");
			System.exit(1);
		}
		return num1 / num2;

	}
}
