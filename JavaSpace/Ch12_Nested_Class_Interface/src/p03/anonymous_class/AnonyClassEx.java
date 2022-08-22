package p03.anonymous_class;

// 자식 클래스를 익명으로 만들어 부모 클래스로 자동형변환하여 사용할 수도 있다.
public class AnonyClassEx {
	public static void main(String[] args) {
		AnonyClass ac = new AnonyClass();
		
		ac.person.wake();
		ac.method1();
		// 자식 익명 객체를 method2의 parameter로 넘김
		ac.method2(new Person() {
			void study() {
				System.out.println("공부를 합니다.");
			}
			
			@Override
			void wake() {
				System.out.println("9시에 일어납니다.");
				study();
			}
		});
		
		
	}
}
