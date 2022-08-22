package p01.basic;

import java.util.Scanner;
//Java Runtime Exception class 사용하여 에러 처리 기법
// 1. try - catch 문법 사용
// 2. try안에는 나누셈 메서드 실행
// 3. 나눗셈 메서드를 실행하면서 Exception인스턴스가 발생함ㄴ\
// - 2-2 try 안에 나누셈 메서드가 실행하면서 Exception instance가 발생되지 않으면 catch안의 코드 실행 안함.
// 4. try 안에 Exception이 발생하여 catch절이 실행되더라도 전체 프로그램의 나머지코드가 정상적으로 실행.
public class QuotientWithException {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("2개의 정수를 입력하시오.");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		try {
			System.out.println(num1+" / "+ num2 + quotient(num1, num2));
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("end of program");
	}

	public static int quotient(int num1, int num2) {
		if (num2 == 0) {
			// 강제로 Exception 발생 (Arithmetic Exception 클래스의 인스턴스를 생성)
			throw new ArithmeticException("분모에 해당하는 값으로 0을 사용할 수 없습니다."	);
		}
		return num1 / num2;

	}
}
