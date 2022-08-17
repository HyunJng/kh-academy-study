package q01.quiz02;

import java.util.Scanner;

// 컴퓨터랑 가위 바위 보
public class Quiz04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int computer = (int) (Math.random() * 3); // 컴퓨터가 내는 것
		int human; // 사람이 내는 것

		// 입력
		System.out.print("가위: 0, 바위: 1, 보: 2 중 하나를 내시오>>");
		human = sc.nextInt();

		// 결과 출력
		System.out.println("컴퓨터는 " + computer);
		switch (human) {
		case 0: // 사용자 가위
			if (computer == 2)
				System.out.println("당신이 이겼습니다.");
			else if (computer == 1)
				System.out.println("당신이 졌습니다.");
			else
				System.out.println("비겼습니다.");
			break;
		case 1: // 사용자 주먹
			if (computer == 0)
				System.out.println("당신이 이겼습니다.");
			else if (computer == 2)
				System.out.println("당신이 졌습니다.");
			else
				System.out.println("비겼습니다.");
			break;
		case 2: // 사용자 보
			if (computer == 1)
				System.out.println("당신이 이겼습니다.");
			else if (computer == 0)
				System.out.println("당신이 졌습니다.");
			else
				System.out.println("비겼습니다.");
			break;

		}

	}
}
