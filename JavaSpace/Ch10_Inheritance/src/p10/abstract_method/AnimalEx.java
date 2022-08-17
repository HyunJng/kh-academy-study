package p10.abstract_method;

public class AnimalEx {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		dog.sound();
		cat.sound();
		
		System.out.println("--------------------");
		
		Animal animal = dog;	//promotion 
		animal.sound();			//polymorphism
		
		animal = cat;		
		animal.sound();
		
		System.out.println("--------------------");

		animalSound(new Dog());
		animalSound(new Cat());
	}
	
	// parameter에서 promotion 
	public static void animalSound(Animal animal) {
		animal.sound();	// polymorphism
	}
}

/*
 * 학원 긑나고도 괜춘. 학원 오기 전도 괜춘.
 * 그럼 11시~14시까지 Discode
 * 시작 괜춘
 */
