package p03.datatypes_promotion;

// 정수형 산술연산에서의 데이터 타입 자동 변환 
// 1. int 보다 작은 byte, char, short를 사용하여 산술연산을 수행하면 무조건 int타입으로 자동형변환 시킴
//    산술연산이 int 타입이라 생각하자
// 2. long, double, float등의 타입과 다른 타입의 산술 연산을 수행하면 큰 데이터 타입으로 자동 형변환

public class TypeConversionInExpressionEx {
	public static void main(String args[]) {
		byte b1 = 42;
		byte b2 = 10;
		byte sum;
		int isum;
		
		char c1 = 20;
		char c2 = 30;
		char csum;
		
		long l1 = 15;
		long result;
		double dresult;
		
//		1. byte타입인 b1을 int타입으로 확장시킴
//		2. byte타입인 b2를 int 타입으로 확장시킴
//		3. b1 + b2를 수행
//		4. int 타입의 결과값을 byte 타입의 sum 에 넣으려고 하니까 에러
//		sum = b1 + b2;
		
		sum = (byte)(b1 + b2);
		isum = b1 + b2;

		csum = (char)(c1 + c2);
		
		// 1. b1 + c1 을 연산하여 int 타입으로 메모리에 저장
		// 2. 앞의 1.의 결과값을 long타입으로 변환 (promotion발생)
		// 3. 앞의 2.의 결과값 + l1
		// 4. 최종값을 long type인 result에 넣음
		result = b1 + c1 + l1;
		
		// long type인 l1과 double type인 0.5를 더할 경우 기계어로는
		// 1. l1을 double타입으로 변환
		// 2. 0.5를 더하여 최종적으로 연산 결과가 double 타입으로 만듬
		//result = l1 + 0.5;
		dresult = l1 + 0.5;
	}
}
