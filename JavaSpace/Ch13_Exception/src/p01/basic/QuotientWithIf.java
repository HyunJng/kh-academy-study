package p01.basic;

import java.util.Scanner;

public class QuotientWithIf {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("2개의 정수를 입력하시오.");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		if(num2!=0)
			System.out.println(num1 + " / " + num2 + " = " + (num1/num2));
		else {
			System.out.println("분모에 0을 사용할 수 없습니다.");
			System.out.println("2번째 입력한 정수값으로 0이아닌 정수를 입력하시오");
		}
		System.out.println("end of program");
	}
}
