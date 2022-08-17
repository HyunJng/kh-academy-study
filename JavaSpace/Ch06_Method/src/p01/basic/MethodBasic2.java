package p01.basic;

//1. method 선언
// 	- 프로그램에서 여러번 반복 사용되는 특정 코드 덩어리를 별도의 method로 정의
//2. method 사용
//	- 선언된 메소드 이름을 통해 메소드 사용
//3. method 사용 효과
// 	- 중복되는 코드는 제거하여 코드 길이를 줄일 수 있다.
// 	- 중복되는 코드 덩어리를 수정할 경우, 메소드 내부에서만 수정하면 되어 코딩 속도 향상.
//4. 사용 예시: 회원가입 여부 check, 상품 가격 체크 등
public class MethodBasic2 {
	public static void main(String[] args) {
//		 기계어 명령어 리스트
//		 1. 등록된  method list에서 sum이라는 이름을 가진 method signiture을 이용하여 찾음
//		 2. 찾은 sum 메소드 호출, 인자에 메모리방을 생성하고 parameter값을 복사하여 넣어줌.
//		 3. result라는 변수에 대하여 메모리방을 생성, method body의 명려어 실행
//		 4. result 변수의 값을 메소드를 호출한 곳으로 return.
//		 	 - 최종 결과값을 return하기 전에 내부 변수들의 메모리는 삭제.
		System.out.println("1과 10사이의 합 : " + sum(1, 10));
		System.out.println("27과 37사이의 합 : " + sum(27, 37));
		System.out.println("35과 49사이의 합 : " + sum(35, 49));
	}
	public static int sum(int startValue, int endValue) {

		int result = 0;

		for (int i = startValue; i <= endValue; i++) {
			result += i;
		}

		return result;
	}
}
