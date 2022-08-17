package q01.quiz02;

import java.util.Scanner;

public class Quiz07 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int seed; 						// 매월 적금 금액
		double year_interest_rate; 		// 년 이자율(%)
		double month_interest_rate; 	// 월 이자율(%)
		int balance = 0; 				// 통장 잔금
		int maturityDay = 6; 			// 만기일
		
		// 월 적금 금액과 1년 이자율 입력
		System.out.print("매월 적금 금액을 입력하시오: ");
		seed = input.nextInt();

		System.out.print("1년 이자율을 입력하시오(%): ");
		year_interest_rate = input.nextInt(); 			// 년 이자율(%)
		month_interest_rate = year_interest_rate / 12; 	// 월 이자율(%)


		// 만기까지 총 금액 구하기
		for (int i = 0; i < maturityDay; i++) {
			balance += seed;
			int after_month = (int) (balance * (100 + month_interest_rate) / 100);
			balance = after_month;
		}

		// 결과 출력
		System.out.println("6개월 뒤 통장 잔금:" + balance);

	}
}
