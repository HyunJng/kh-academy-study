package p05.for_basic;

public class ForBasic2 {
	public static void main(String[] args) {

		System.out.println("구구단은 다음과 같습니다.");

		for (int n = 2; n <= 9; n++) {
			System.out.println(n + "단");
			for (int m = 1; m <= 9; m++) {
				System.out.println(n + " * " + m + " = " + n * m);
			}
			System.out.println();
		}
		System.out.println("끝");
	}
}
