package p02.practice;

import java.util.Scanner;
// method의 장점
// 1. 한번 코딩해 두면 다름사람에게도 공유 가능(더 이상 중복된 코딩을 할 필요가 없다.)
// 2. method를 사용하는 사람은 method 내부를 몰라도 이용 가능.
// 3. 개발 생산성과 코드 재활용성이 높아짐.
public class GreatestCommonDivisor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("첫번째 정수를 입력하시오 :");
		int n1 = sc.nextInt();

		System.out.print("두번째 정수를 입력하시오 :");
		int n2 = sc.nextInt();

		int result = gcd(n1, n2);

		System.out.println("입력된 정수들의 최소 공약수는 " + result + " 입니다.");
	}

	// 최대공약수 구하는 메소드
	public static int gcd(int n1, int n2) {

		int gcd = 1;
		int k = 2;

		while (k <= n1 && k <= n2) {

			if (n1 % k == 0 && n2 % k == 0)
				gcd = k;
			k++;
		}
		return gcd;
	}
}
