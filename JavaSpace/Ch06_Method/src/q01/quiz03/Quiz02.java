package q01.quiz03;

import java.util.Scanner;

public class Quiz02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();

		int flag = 0;
		int cnt = 0;

		for (int i = 0; i < id.length(); i++) {
			// 1. '-'위치 확인
			if (id.charAt(i) == '-') {
				if (i != 3 && i != 6) {
					flag = 1;
					break;
				}
			}
			// 2. 숫자가 맞는지 확인
			else if (!Character.isDigit(id.charAt(i))) {
				flag = 1;
				cnt ++;
				break;
			}
		}

		if (flag == 1 && cnt == 9)
			System.out.println(id + "는 사원 번호 형식이 틀립니다.");
		else
			System.out.println(id + "는 사원 번호 형식이 맞습니다.");
	}
}
