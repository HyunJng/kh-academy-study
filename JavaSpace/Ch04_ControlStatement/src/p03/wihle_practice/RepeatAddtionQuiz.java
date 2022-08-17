package p03.wihle_practice;

import java.util.Random;
import java.util.Scanner;

// 0 ~ 9사이의 2개의 수를 random으로 생성하여 합을 구한 후
// 사요앚로부터 console에서 덧셈 결과를 입력받아 
// 내부적으로 생성한 덧셈 결과와 일치할 때까지 반복
public class RepeatAddtionQuiz {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int num1 = (int)(Math.random() * 10);
		int num2 = (int)(Math.random() * 10);
		int sum = num1 + num2;

		while (true) {
			System.out.print(num1 + "+" + num2 + ">>");
			int answer = input.nextInt();
			if (answer == sum) {
				System.out.println("맞았습니다.");
				break;
			}
		}

	}
}
