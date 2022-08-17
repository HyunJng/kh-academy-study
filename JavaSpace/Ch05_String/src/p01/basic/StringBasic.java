package p01.basic;

//String type 
//1. 메모리에서 사용하는 데이터 크기가 가변적인 것이 특징임.
// -> 실제 데이터는 힙메모리에 저장, 변수에는 힙메모리의 주소값은 stack으로 저장
//2. 실제 사용 예 : 고객이름, 주소, 직업, 회사명, 상품명, ...등
//3. 산술 연산 기호 중에서 +만 사용 가능 -> 문자열 합치기
// 	- 문자열 + 문자열 (O)
// 	- 숫자 + 문자열 (O)
//	- 문자열 + 숫자 (O)
public class StringBasic {
	public static void main(String[] args) {
		String message1 = "안녕하세요. 배고파요.";
		String message2 = "배가 고픈데 먹긴 싫어요";
		String message3;
		
		System.out.println(message1);
		System.out.println(message2);
		message3 = message1 + " " + message2;
		
		System.out.println(message3);
		
		message3 = 2 + 3 + message1 + 2 + 3;
		System.out.println(message3);
	}
}
