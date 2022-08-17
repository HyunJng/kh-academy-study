package p07.break_continue;

import java.util.Scanner;

public class BreakEx2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input;
		int num = 0;
		do {
			System.out.print("숫자를 입력하세요(종료: -1) >>");
			input = sc.nextInt();
			num++;
		}while(input != -1);
		System.out.println("종료되었습니다. 입력된 수 : " + (num - 1));
	}
}
