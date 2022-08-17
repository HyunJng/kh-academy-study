package q01.quiz03;

import java.util.Scanner;

public class Quiz10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하시오.");
		int number = sc.nextInt();
		Reverse(number);
	}

	public static void Reverse(int number) {
		String stringNum = Integer.toString(number);

		for (int i = stringNum.length() - 1; i >= 0; i--) {
			System.out.println(stringNum.charAt(i));
		}
	}
	
	public static void Reverse2(int number) {
		while(number != 0) {
			int temp = number % 10;
			System.out.print(temp);
			number /= 10;
		}
	}
}
