package p05.for_basic;

// for믄에서 증감 단위가 소수점인 경우도 사용 가능
// 실제 쾽에서는 실수 연산은 오차가 발생하기 때문에 비추천
// 사용하면 먼저 정수로 변환하여 for문 사용하고 마지막에 실수화 하기.
public class ForBasic4 {
	public static void main(String[] args) {
		float fSum = 0f;

		for (float i = 0.01f; i <= 1.0f; i += 0.01f) {
			fSum += i;
		}

		System.out.println("fSum = " + fSum);
		
		double dSum = 0.0;
		for(double i = 0.01; i<=1.0; i+=0.01) {
			dSum += i;
		}
		
		System.out.println("dSum = "+ dSum);
		
	}
}
