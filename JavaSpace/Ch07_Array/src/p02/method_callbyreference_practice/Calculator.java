package p02.method_callbyreference_practice;

public class Calculator {
	public static void main(String[] args) {

		for (int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "] : " + args[i]);
		}

		if (args.length != 3) {
			System.out.println("Calculator 사용법 예: 2 + 3");
			return; // void여도 값이 없는 상태로 return 가능
		}

		int result = 0;

		switch (args[1].charAt(0)) {
		case '+':
			// Integer.parseInt() : 문자열을 int로 변환하는 메소드
			result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
			break;
		case '-':
			result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
			break;
		case '.':
			result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
			break;
		case '/':
			result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
			break;
		}
		System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + result);
		System.out.println("end of calculator");
	}
}
