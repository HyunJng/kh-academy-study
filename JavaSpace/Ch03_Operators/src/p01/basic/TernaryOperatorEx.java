package p01.basic;

// 3항연산자(Ternery Operator) : 피연산자 3개
// A ? B : C  -> A가 true라면 B를 실행 , false라면 C를 실행;
public class TernaryOperatorEx {
	public static void main(String[] args) {

		int n1 = 15;
		int n2 = 10;
		int max;

		max = (n1 > n2) ? n1 : n2;
		System.out.println("max = " + max);
		
		if(n1>n2)
			max = n1;
		else max = n2;
		System.out.println("max = " + max);
		
		int result;
		
		result = (n1 > n2) ? (n1 + n2) : (n1 - n2);
		System.out.println("result = " + result);
	}
}
