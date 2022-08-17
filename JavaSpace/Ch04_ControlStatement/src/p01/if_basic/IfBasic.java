package p01.if_basic;

import java.util.Scanner;

public class IfBasic {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("원의 반지름을 입력하세요.");
		int radius = input.nextInt();
		final double PI = 3.14159;
		double area = 0;

		if (radius >= 0) {
			area = radius * radius * PI;
			System.out.println("원의 면적은 " + area + "입니다.");
		} else {
			System.out.println("반지름은 양수만 가능합니다.");
		}

	}
}
