package p05.for_basic;

import java.util.Scanner;

// ;(세미콜로)으로 끝나는건 모두 명령식.
// for문에는 명령식이 3개 포함된 것
// while문에서도 초기값, 조건식, 증감명령어가 있었는데 이를 압축한게 for.
// 초기값과 마지막 값이 결정되어 있는 경우에 많이 사용.
public class ForBasic {
	public static void main(String[] args) {
		int sum = 0;
		Scanner sc = new Scanner(System.in);

		System.out.print("N ~ M 의 합계를 구한다. ");
		System.out.print("N, M >> ");
		int startNumber = sc.nextInt();
		int lastNumber = sc.nextInt();
		for (int number = startNumber; number <= lastNumber; number++) {
			sum += number;
		}

		System.out.println(startNumber + " ~ " + lastNumber + " 의 합 = " + sum);
	}
}
