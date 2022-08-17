package p02.enumtype;

// 개발할 때 상수를 사용하는 경우가 많다.ex) 직급, 고객등급
// final등을 이용하여 상수를 만들 때 문제점
// - 여러명과 같이 프로그램을 만들 때 공유하는 상수를 강제적으로 사용하도록 하기가 어려움(변경, 편법 등이 있을 수 있다.)
// enum(enumeration, 열거) type을 통해 해결
// - 모든 사람이 동일한 상수를 강제적으로 사용하게 만들 수 있다.
public class EnumTypeBasic {
	public static void main(String[] args) {
		// final로 상수 만듬 << 문제가 발생
		final double PI = 3.14159;
		final String[] LEVEL = {"사원", "주임", "대리", "과장", "차장", "부장"};
	}
}
