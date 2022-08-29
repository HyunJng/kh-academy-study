package p01.basic;
// Lamda Expression 정의
// 1. Interface의 추상메서드로만 사용 가능
// 2. Interface의 추상메서드가 1개만 있을 경우만 사용 가능
// 3. lamda expression 으로 생성된 인스턴스는 내부적으로 Interface를 자식 익명객체로 만든 것과 동일
// 4. lamda expression 예
// 	* () -> { System.out.println("Hello, Lamda MyInterface Instance");};
//		=> sayHello()추상메서드를 구현한 것을 표현
//		. () : method parameter list
//		. {system.out.println("Hello, ~");} : sayHello method의 body를 coding한 것.
public class LamdaEx {
	
	public static void main(String[] args) {
		MyInterfaceImpl mi = new MyInterfaceImpl();
		mi.sayHello();
		
		MyInterface ma = new MyInterface() {
			
			@Override
			public void sayHello() {
				System.out.println("Hello, Anonymous MyInterface Instance");
			}
		};
		
		ma.sayHello();
		
		// Lamda 표기법
		MyInterface ml = () -> {
			System.out.println("Hello, Lamda MyInterface Instance");
		};
		
		ml.sayHello();
		
	}
}
