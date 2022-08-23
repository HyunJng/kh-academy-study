package p05.throw_exception;

// main method에서 Throw Exception을 사용한 경우
// 1. JVM이 main에서 method가 넘긴 Exception을 실행함
// 	-> user friendly하지 않아서 비추천
// 2. 절대로 main method에서 throws사용하지 말 것.

public class ThrowExceptionEx2 {
	public static void main(String[] args) throws ClassNotFoundException {
			findClass();
			System.out.println("정상 처리 됨");
	}
	
	public static void findClass() throws ClassNotFoundException {
		Class slc = Class.forName("java.lang.Sring2");
	}
}
