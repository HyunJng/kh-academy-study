package q01.quiz02;

import java.util.Scanner;

public class Quiz05 {
	public static void main(String[] args) {
		int target = (int) (Math.random() * 100); // 랜덤숫자
		int answer; // 사용자의 답
		Scanner sc = new Scanner(System.in);

		System.out.println("0 ~ 100까지의 숫자를 추측해보세요");
		do {
			answer = sc.nextInt();
			if (target > answer)
				System.out.println("당신이 추측한 숫자보다 큽니다.");
			else if (target < answer)
				System.out.println("당신이 추측한 숫자보다 작습니다.");
			else {
				System.out.println("정확히 맞추었습니다.");
				break;
			}
		} while (true);
	}
}
