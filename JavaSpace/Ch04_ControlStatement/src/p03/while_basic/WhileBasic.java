package p03.while_basic;

// while문은 '초기값'과 '조건식'을 잘 볼 것
public class WhileBasic {
	public static void main(String[] args) {

		// 반복문의 초기화
		int i = 5;
		while (i != 0) {
			System.out.println("Java씨, 존경합니다.");
			i--; // while문의 조건식 결과를 false로 만들어 줄 수 있음.
		}

		System.out.println();
		i = 1;
		while (i <= 10) {
			System.out.println("자바씨 존경합니다.");
			i++;
		}

		System.out.println();
		i = 1;
		int endValue = 10;
		while (i <= endValue) {
			System.out.println("존경");
			i++;
		}
	}
}
