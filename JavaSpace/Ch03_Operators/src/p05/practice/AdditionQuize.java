package p05.practice;

import java.util.Scanner;

// 2개의 숫자를 프로그램 내부에서 자동 생성하여 더하기 퀴즈 뮨재룰 냐눈 풇구럄
public class AdditionQuize {
	public static void main(String[] args) {
		
		long currentTimeMillise = System.currentTimeMillis();
		int num1 = (int)(currentTimeMillise % 10 + 1);
		int num2 = (int)(currentTimeMillise / 10 % 10 + 1);
		
		System.out.println("currentTimeMillise = " + currentTimeMillise);
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
	
		Scanner input = new Scanner(System.in);
		
		System.out.println("숫자 "+ num1 + "과 숫자 " + num2 + "의 합계는 얼마?");
		int answer = input.nextInt();
		boolean bCorect = ((num1 + num2) == answer);
		if(bCorect)
			System.out.println("맞았습니다.");
		else
			System.out.println("틀렸습니다.");
		
	}
}
