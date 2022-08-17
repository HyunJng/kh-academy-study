package p01.if_practice;

import java.util.Scanner;

//////////////////////////////////////////////////////////////////////
//	뺼셈 퀴즈 : 2개의 정수로부터 뺄셈 연산 수행									//
//	 >>> 1. 결과 값을 항상 양의 정수로 출력 (num1 - num2 일떄 항상 num1 > num2)	//
//	 >>> 2. 2개의 정수값은 0 ~ 9 사이의 숫자								//
//////////////////////////////////////////////////////////////////////

public class SubtractQuiz {
	public static void main(String[] args) {
		// Math.random() : 0 ~ 1 사이의 실수값을 return
		int num1 = (int) (Math.random() * 10);
		int num2 = (int) (Math.random() * 10);

		if (num1 < num2) {
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}

		System.out.println(num1 + " - " + num2 + " = ?");
		Scanner input = new Scanner(System.in);
		int answer = input.nextInt();

		if ((num1 - num2) == answer)
			System.out.println("맞았습니다.");
		else {
			System.out.print("틀렸습니다. ");
			System.out.println("답은 " + (num1 - num2) + " 입니다.");
		}
	}
}
