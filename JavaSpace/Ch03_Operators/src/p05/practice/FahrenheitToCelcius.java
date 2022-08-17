package p05.practice;

import java.util.Scanner;

// 화씨(F) -> 섭씨(C)
public class FahrenheitToCelcius {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("화씨(F)를 입력하시오.");
		double fahrenheit = input.nextDouble();

		double Celcius = (5.0 / 9) * (fahrenheit - 32);
		System.out.println("입력된 화씨 " + fahrenheit + "는 섭씨 " + Celcius + "입니다.");

	}
}
