package p01.basic;

// 논리 연산자(Logical Operator) : &&, ||, !
public class LogicalOperatorEx {
	public static void main(String[] args) {
		int a1 = 10;
		int a2 = 20;
		int a3 = 20;
		boolean bResult;
		
		bResult = (a1 < a2) && (a2 == a3);
		System.out.println("bResult = " + bResult);
		bResult = (a1 < a2) || (a2 == a3);
		System.out.println("bResult = " + bResult);
		
		bResult = (a1 > a2) && (a2 == a3);
		System.out.println("bResult = " + bResult);
		bResult = (a1 > a2) || (a2 == a3);
		System.out.println("bResult = " + bResult);

		bResult =!(a1 > a2);
		System.out.println("bResult = " + bResult);
		
		
	}
}
