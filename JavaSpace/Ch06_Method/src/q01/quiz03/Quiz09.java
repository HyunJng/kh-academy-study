package q01.quiz03;

import java.util.Scanner;

public class Quiz09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하시오.");
		long num = sc.nextLong();
		int sum = sumDigits(num);
		System.out.println("각 자리의 합은 " + sum + "입니다.");
	}

	// 스트링으로 받아서 하면 안되나?
	public static int sumDigits(String n) {
		int sum = 0;
		for (int i = 0; i < n.length(); i++) {
			sum += (int) n.charAt(i) - '0';
		}
		return sum;
	}

	// long 버전
	public static int sumDigits(long n) {
		String temp = Long.toString(n);
		return sumDigits(temp);
	}
	
	// 계산 버전
	public static int sumDigit(int n) {
		int sum = 0;
		while(n != 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
}
