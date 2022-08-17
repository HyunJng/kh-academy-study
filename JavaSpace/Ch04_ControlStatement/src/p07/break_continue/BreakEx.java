package p07.break_continue;

import java.util.Scanner;

public class BreakEx {
	public static void main(String[] args) {

		int num = 0;
		
		do {
			num = (int)(Math.random() * 6) + 1;
			System.out.println("주사위번호 = "+ num);
		}while(num != 6);
		System.out.println("주사위 게임 종료");
		System.out.println();
		
		// 0.1 ~ 0.9 * 6 == 0.6 1.2 18 ... 5.4 + 1;
		while(true) {
			num = (int)(Math.random() * 6) + 1;
			System.out.println("주사위번호 = "+ num);
			if(num == 6)
				break;
		}
		System.out.println("주사위 게임 종료");
		/*
		//음식 주문 자동 기계, 커피 자판기 처럼 무한 반복하여 주문을 받는 프로그램에서 많이 사용
		while(true) {
			//음식 메뉴 화면 display
			System.out.println("짜장면, 짬뽕, 탕수욕, 울면, 볶음밥 중 주문할 음식은?>>");
			//주문한 음식 메뉴 입력 받음
			Scanner sc = new Scanner(System.in);
			
			//주문된 음식 요리
			//고객에게 음식 완성 메세지 display
		}
		*/
	}
}
