package p05.practice;

import java.util.Scanner;

public class DisplayTime {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("3600이하의 숫자를 입력하세요.");

		int seconds = input.nextInt();
		int minutes = seconds / 60;
		int remainingSeconds = seconds % 60;
		System.out.println("입력된 " + seconds + "초를 계산하면 " 
				+ minutes + "분 " + remainingSeconds + "초입니다.");
	}
}
