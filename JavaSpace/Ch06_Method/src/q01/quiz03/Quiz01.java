package q01.quiz03;

import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		System.out.println("학생 정보를 입력하시오.(ex. A1)");
		System.out.println("I:정보학과, A:회계학과, C:컴퓨터학과");
		System.out.println("학년: 1, 2, 3, 4 중 하나");

		// 학생 정보
		char major = id.charAt(0);
		char level = id.charAt(1);
		String result = ""; // 결과

		switch (major) {
		case 'I':
			result = "정보학과 ";
			break;
		case 'A':
			result = "회계학과 ";
			break;
		case 'C':
			result = "컴퓨터학과 ";
			break;
		}

		System.out.println(result + level + "학년 입니다.");

	}
}
