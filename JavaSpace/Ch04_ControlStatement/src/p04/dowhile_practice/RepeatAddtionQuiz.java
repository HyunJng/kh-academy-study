package p04.dowhile_practice;

import java.util.Scanner;

public class RepeatAddtionQuiz {
	public static void main(String[] args) {
		int num1 = (int) (Math.random() * 10);
		int num2 = (int) (Math.random() * 10);
		Scanner sc = new Scanner(System.in);
		int answer = Integer.MAX_VALUE;
		
		do {
			System.out.print(num1 + "+" + num2 + ">> ");
			answer = sc.nextInt();
		} while((num1 + num2) != answer);
		
		System.out.println("정답입니다.");
	}
}
