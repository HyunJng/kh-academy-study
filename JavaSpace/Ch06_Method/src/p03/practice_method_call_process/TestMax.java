package p03.practice_method_call_process;

//JVM이 method 실행 방식 : activation record를 메모리 stack영역에 할당하는 방식.
//1. method호출순서
// 	- main > max
//2. main 함수의 actual parameter 값이 max 함수의 formal parameter로
//	값이 복사됨 (call by value)
//3. call by value : method의 formal parameter로 actual parameter값이 복사되는 것.
//4. call by reference : method의 formal parameter로 actual parameter의 주소가 복사.
public class TestMax {
	public static void main(String[] args) {

		int n1 = 5;
		int n2 = 12;
		int n3 = max(n1, n2);

		System.out.println(n1 + "과 " + n2 + "중 최대값: " + n3);

	}

	public static int max(int n1, int n2) {
		int result;

		if (n1 > n2)
			result = n1;
		else
			result = n2;

		return result;
	}
}
