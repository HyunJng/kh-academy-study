package p05.throw_exception;

// Throws Exception 처리 방법
// 1. 원칙 : Exception이 발생한 메서드에서 try ~ catch를 사용하여 exception 처리하는 것이 원칙
// 2. Exception이 발생한 메서드를 호출하는 상위 메서드에서 처리하도록 하는 방법
//	 - 하위 메서드에서 throws Exception 선언
//	 - 상위 메서드에서는 모든 종류의 exception을 한번에 처리할 경우에 사용함.
public class ThrowExceptionEx {
	public static void main(String[] args) {
		try {
			findClass();
			System.out.println("정상 처리 됨");
		} catch (ClassNotFoundException e) {
			System.out.println("compile-time Exception 발생");
		}
	}
	
	// method선언문에서 throws Exception의미
	// method 내부에서 해당 예외가 발생하면 메서드를 호출한 메서드로 Exception을 넘김 
	public static void findClass() throws ClassNotFoundException {
		Class slc = Class.forName("java.lang.Sring2");
	}
}
