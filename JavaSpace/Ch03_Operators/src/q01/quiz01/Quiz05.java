package q01.quiz01;

import java.util.Scanner;

public class Quiz05 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		
		System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
		System.out.println(num1 + "-" + num2 + "=" + (num1 - num2));
		System.out.println(num1 + "*" + num2 + "=" + (num1 * num2));
		System.out.println(num1 + "," + num2 + "의 평균 : " + (num1 + num2) / 2.0);
		System.out.println(num1 + "," + num2 + "의 최대값 : " + Math.max(num1, num2));
		System.out.println(num1 + "," + num2 + "의 최솟값 : " + Math.min(num1, num2));
	}
}
