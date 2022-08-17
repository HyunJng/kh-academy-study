package q01.quiz03;

import java.util.Scanner;

public class Quiz05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열을 입력하시오.");
		String input = sc.next();
		int letterNum = countLetter(input);

		System.out.println("전체 문자 개수는 " + letterNum + "입니다.");
	}

	public static int countLetter(String s) {
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isAlphabetic(s.charAt(i)))
				cnt++;
		}
		return cnt;
	}
}
