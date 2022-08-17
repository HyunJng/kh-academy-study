package q01.quiz02;

import java.util.Scanner;

public class Quiz06 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int positiveNum = 0; // 양수의 전체 개수
		int negativeNum = 0; // 음수의 전체 개수
		int totalSum = 0; // 전체 합
		int input, average;

		System.out.println("정수를 입력하시오(중지: 0)");
		while (true) {
			System.out.print(">> ");
			input = sc.nextInt();

			// 중지조건
			if (input == 0)
				break;

			// 양수, 음수 개수 세기
			if (input > 0)
				positiveNum++;
			else
				negativeNum++;

			// 전체 합 계산
			totalSum += input;
		}

		// 평균 계산
		average = totalSum / (positiveNum + negativeNum);

		System.out.println("양의 개수 : " + positiveNum);
		System.out.println("음의 개수 : " + negativeNum);
		System.out.println("전체 합 : " + totalSum);
		System.out.println("전체 평균값: " + average);
	}
}
