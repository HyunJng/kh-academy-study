package q01.quiz03;

import java.util.Scanner;

public class Quiz03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 문자열을 입력하시오.");
		String s1 = sc.next();
		System.out.println("두번째 문자열을 입력하시오.");
		String s2 = sc.next();

		if (s1.contains(s2))
			System.out.println(s2 + "는 " + s1 + "의 substring입니다.");
		else
			System.out.println(s2 + "는 " + s1 + "의 substring이 아닙니다.");

	}
}
