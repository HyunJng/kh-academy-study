package p08.practice2;

public class TestEdible {
	public static void main(String[] args) {
		Object[] obj = { new Tiger(), new Chicken(), new Orange(), new Apple() }; // promotion

		for (int i = 0; i < obj.length; i++) {
			if(obj[i] instanceof Edible) {
				Edible e = (Edible) obj[i];
				System.out.println(e.howToEat());// polymorphism
			}
			if(obj[i] instanceof Animal) {
				Animal a = (Animal) obj[i];
				System.out.println(a.sound());
			}
		}
	}
}
