package p01.basic;

// 연산자 우선순위(Operator Precedence)
public class OperatorPrecedenceEx {
	public static void main(String[] args) {
		int result = 0;

		result = 5 - 2 + 3 - 6;
		System.out.println("result = " + result);

		result = 3 - 4 / 2 + 8 * 4 - (5 + 2) % 3;
		System.out.println("result = " + result);
		
	}
}
