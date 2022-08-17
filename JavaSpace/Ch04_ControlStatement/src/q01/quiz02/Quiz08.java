package q01.quiz02;

import java.util.Scanner;
import java.util.Vector;

public class Quiz08 {
	public static void main(String[] args) {

		int totalNum;
		int maxScore = 0;
		Scanner sc = new Scanner(System.in);

		// 입력
		System.out.print("전체 학생 수를 입력하세요 ");
		totalNum = sc.nextInt();

		System.out.println();

		// 학생수만큼 입력, max구하기
		for (int i = 0; i < totalNum; i++) {
			System.out.print("점수를 입력하시오 >>");
			int temp = sc.nextInt();
			if (maxScore < temp)
				maxScore = temp;
		}

		// 출력
		System.out.println("최고 점수는 : " + maxScore);
	}
}
