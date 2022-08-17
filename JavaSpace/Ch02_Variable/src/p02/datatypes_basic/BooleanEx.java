
package p02.datatypes_basic;
// boolean타입
// 1. 리터럴 값이 true false만 가능
// 2. if, while, for 등 제어문에서 사용
// 3. 현실 세계에서는 필요없는 데이터 타입이지만, 프로그래밍 할 떄는 핵심 타입

public class BooleanEx {
	public static void main(String args[]) {
		boolean stop = true;
		boolean start = false;

		System.out.println("stop = " + stop);
		System.out.println("start = " + start);
		
		if(stop) 
			System.out.println("중지합니다.");
		else
			System.out.println("시작합니다.");
		
	}
}
