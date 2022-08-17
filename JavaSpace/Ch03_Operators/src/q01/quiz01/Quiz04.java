package q01.quiz01;

import java.util.Scanner;

// 4개의 정수값을 키보드로부터 읽어 동일한지 구하기
public class Quiz04 {
	public static void main(String[] args) {
		// 입력
		Scanner input = new Scanner(System.in);
		int	num1 = input.nextInt();
		int	num2 = input.nextInt();
		int	num3 = input.nextInt();
		int	num4 = input.nextInt();
		
		int flag = 0;	// 0이면 동일 1이면 다름
		
		// 비교
		if(!((num1 == num2) && (num3 == num4)))
			flag = 1;
		
		// 출력
		if(flag == 1) System.out.println("4개의 정수값이 동일하지 않습니다.");
		else System.out.println("4개의 정수값이 동일합니다.");
	}
}

