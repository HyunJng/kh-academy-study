package p03.anonymous_class;

public class AnonyClass {
	// Person의 익명자식클래스의 인스턴스를 만들고, 부모로 promotion
	Person person = new Person() {
		void work() {
			System.out.println("출근합니다.");
		}
		
		@Override
		void wake() {
		 System.out.println("6시에 일어납니다.");
		 work();
		}
	};
	
	
	public AnonyClass() {
		System.out.println("AnonyClass constructor call");
	}
	
	void method1() {
		Person lacalVar= new Person() {
			void walk() {
				System.out.println("산책합니다.");
			}
			
			@Override
			void wake() {
				System.out.println("8시에 일어납니다.");
				walk();
			}
		};

		lacalVar.wake();
	}
	
	void method2(Person person) {
		person.wake();
	}
}
