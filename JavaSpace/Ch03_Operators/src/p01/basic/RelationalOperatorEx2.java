package p01.basic;

// 1. char로  비교연산자를 사용할 경우 유니코드 순으로 비교
// 2. 실수 값끼리 절대 비교 연산자 사용하지 말 것. << 오차 때문
public class RelationalOperatorEx2 {
	public static void main(String[] args) {
		char ch1 = 'A';
		char ch2 = 'B';
		
		boolean bResult = (ch1 < ch2);
		System.out.println("bResult = " + bResult);
		
		double d1 = 0.6;
		float f1 = 0.6f;
		
		bResult = ((int)d1 * 10 == (int)f1 * 10);
		System.out.println("bResult = " + bResult);
		
		bResult = ((float)d1 == f1);
		System.out.println("bResult = " + bResult);
		
	}
}
