package p01.basic2;

// Lamda 표기법 규칙
// 1. method 본문 내용코딩을 가능하면 하나의 명령어로 coding할 것.
//	-> 추상 메서드 body의 명령어가 한개라면 {} 생략 가능
public class MyFunctionalInterfaceEx {
	public static void main(String[] args) {
		MyFunctionalInterface m1= () -> {	 // 코딩 긴 것은 바람직 X
			String str = "method call1";
			System.out.println(str);
		};
		
		m1.method();
		
		m1 = () -> {System.out.println("method call2");};
		m1.method();
		
		m1 = () -> System.out.println("method call3");
		m1.method();
		
	}
}
