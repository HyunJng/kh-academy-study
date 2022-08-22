package p02.runtime_exception;


// ClassCastException
// - 부모 인스턴스를 자식 인스턴스로 강제 형변환할 떄 발생하는 Exception
public class ClassCastExceptionEx {
	public static void main(String[] args) {
	
		try {
			Dog dog = new Dog();
			changeDog(dog);
			System.out.println("dog 인스턴스로 캐스팅 되었습니다.");
			
			Cat cat = new Cat();
			changeDog(cat);
		} catch (ClassCastException e) {
			System.out.println("Dog instance로 변환이 불가합니다.");
		}
		
		
	}
	
	public static void changeDog(Animal animal) {
//		if (animal instanceof Dog) {
			Dog dog = (Dog) animal;
//			System.out.println("dog 인스턴스로 캐스팅 되었습니다.");
//		}else {
//			System.out.println("Dog instance로 변환이 불가합니다.");
//		}
	}
}

class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}
