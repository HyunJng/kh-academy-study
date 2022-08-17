package p02.method_callbyreference_practice;

// max 구하기
// 1.여러개의 parameter을 array를 이용하여 넘길 수 있다.
//	 =>여러 인자의 method overloading을 하지 않아도 된다.abstract
// 2. parameter로 배열과 유사한 다른 표기법 - '...' 사용한 표기법
//	- actual parameter로 배열을 사용해도 인식된다.
//	- actual parameter로 primitive type을 여러개 가변적으로 넘겨도 인식된다.
public class VarAgsDemo {
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int c = 3;
		int maxValue;
		
		maxValue = max(a, b);
		System.out.println("maxValue : " + maxValue);
		maxValue = max(a, b, c);
		System.out.println("maxValue : " + maxValue);
		
		int numbers[] = {1, 2, 3, 5, 1, 8};
		maxValue = max(numbers);
		System.out.println("maxValue : " + maxValue);
		
		maxValue = max(15, 24, 46, 77, 11, 38);
		System.out.println("maxValue : " + maxValue);
	}
	public static int max(int... num) {
		int result = 0;

		for (int k : num) {
			
			if (result < k)
				result = k;
		}

		return result;
	}
	
/*	
	// 개수가 상관 없어진다는 장점이 있다.
	public static int max(int[] num) {
		int result = 0;

		for (int k : num) {
			if (result < k)
				result = k;
		}

		return result;
	}

	public static int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}

	public static int max(int a, int b, int c) {
		int result;

		result = max(max(a, b), c);

		return result;
	}
 */
}
