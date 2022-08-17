package q01.quiz01;

import java.util.Scanner;

// 분 단위의 숫자를 키보드에서 읽어, 
// 일의 수와 년의 수를 구하여 출력하시오

public class Quiz02 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int day_minute = 24 * 60;
		int year_day = 365;

		System.out.print("분 단위의 숫자를 입력하시오: ");
		int input_minute = input.nextInt();

		int resultDay = input_minute / day_minute;
		System.out.println("일의 수 : " + resultDay);

		int resultYear = resultDay / year_day;
		System.out.println("년의 수 : " + resultYear);
	}
}
