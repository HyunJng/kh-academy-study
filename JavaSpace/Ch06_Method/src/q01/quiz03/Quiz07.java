package q01.quiz03;

import java.util.Scanner;

public class Quiz07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("매월 적금 금액, 년 이자율, 적금 기간(월단위)를 순서대로 입력하시오.");
		double amount = sc.nextDouble();
		double yearlyRate = sc.nextDouble();
		double monthlyRate = yearlyRate / 12;
		int numOfMonth = sc.nextInt();

		double result = calculateSaving(amount, monthlyRate, numOfMonth);
		System.out.println("총 " + numOfMonth + "개월 지난 후의 적금액은 " + result + "입니다.");
	}

	public static double calculateSaving(double amount, double monthlyRate, int numOfMonth) {
		double balance = 0; // 통장 잔금

		// 만기까지 총 금액 구하기
		for (int i = 0; i < numOfMonth; i++) {
			balance += amount;
			double after_month = (balance * (100 + monthlyRate) / 100);
			balance = after_month;
		}
		return balance;
	}
}
