package p01.if_basic;

public class IfBasic2 {
	public static void main(String[] args) {
		int i = -15;

		if (i > 0)
			System.out.println("i는 양수입니다.");

		if (i > 0)
			System.out.println("i가 역시 양수입니다.");

		if (i % 2 == 0)
			System.out.println("i는 2의배수/짝수입니다.");
		
		if (i % 2 == 1)
			System.out.println("i는 홀수입니다.");

		if (i % 5 == 0)
			System.out.println("i는 5의 배수입니다.");

		if ((i % 2 == 0) || (i % 5) == 0)
			System.out.println("i는 2의 배수이거나 5의 배수입니다.");

		if ((i % 2 == 0) && (i % 5) == 0)
			System.out.println("i는 10의 배수입니다.");

	}
}
