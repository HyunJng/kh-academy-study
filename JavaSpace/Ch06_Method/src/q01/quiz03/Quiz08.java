package q01.quiz03;

import java.util.Scanner;

public class Quiz08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 3개를 입력하시오.");
		double num1 = sc.nextDouble();
		double num2 = sc.nextDouble();
		double num3 = sc.nextDouble();

		displaySortedNumber(num1, num2, num3);
	}

	public static void displaySortedNumber(double... num) {

		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length - (i + 1); j++) {
				if (num[j] < num[j + 1]) {
					double temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
				}
			}
		}

		for (double k : num)
			System.out.print(k + " ");
	}
}
