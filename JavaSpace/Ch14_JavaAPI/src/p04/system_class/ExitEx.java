package p04.system_class;


// System class 의 exit(int status) 
// 1. 사용목적 : 프로그램 강제 종료
// 2. status parameter (결론은 똑같은데 암묵적인 의미)
// 	- 0: 정상종료 
// 	- !0:비정상 종료 (개발자가 의사결정)
// 		ex) 1: Hardware Error, 2: Network Error ...
// 3. System.setSecurityManager 메서드를 통해 status값이 특정 정수 값인 경우만 프로그램이 강제 종료 되도록 코딩 가능
// 	- 방법 : setSecurityManager(익명객체 SecurityManager를 넣고 checkExit를 오버라이드)
// 	- 이유 : exit() 메서드를 실행하면 JVM이 시스템을 강제 종료하기 전에 checkExit() 메서드를 자동 실행하기 때문.
// 4. 이 예제에서 사용한 개념
//	- 자식 클래스로 익명객체를 생성하여 method의 parameter로 넘김
//	- method의 parameter 타입이 부모클래스여서 자식인 익명객체가 부모 클래스로 promotion됨.
// 	- 익명객체에서 부모 클래스의 메서드를 override했기 때문에, 부모 인스턴스에서 부모 메서드를 실행할 때 오버라이드된 익명객체의 메서드가 실행된다.(Polymorphism)
public class ExitEx {
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager() {
			@Override
			public void checkExit(int status) {
				if (status != 5) {
					throw new SecurityException();
				}
			}
		});

		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			
			try {
				System.exit(i);
			} catch (SecurityException e) {
				System.out.println("Security Exception 호출됨");
			}
		}
	}
}
