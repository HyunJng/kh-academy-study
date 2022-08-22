package collection;

import java.util.ArrayList;

class Fruit implements Etable{
	public String toString() { return "Fruit"; }
}

class Apple extends Fruit { public String toString() {return "Apple";}}
class Grape extends Fruit { public String toString() {return "Grape";}}
class Toy				 {public String toString() {return "Toy";}}

interface Etable{}

public class GenericsEx2 {
	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<>();
		FruitBox<Grape>	grapeBox = new FruitBox();
//		FruitBox<Toy> toyBox = new FruitBox();  // Fruit나 eatable을 상속하지 않아서 x
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		fruitBox.add(new Apple());
//		appleBox.add(new Grape()); // Apple과 관련 없음
		appleBox.add(new Apple());
//		appleBox.add(new Fruit());	// 조상클래스도 넣으면 안됨
		
		System.out.println("FruitBox - "+ fruitBox);
		System.out.println("AppleBox - " + appleBox);
		
		System.out.println(fruitBox.get(1));
	}
}


class FruitBox<T extends Fruit & Etable> extends Box<T>{}	// Box인데 Fruit만 담을 수 있는 새로운 Box

class Box<T>{
	ArrayList<T> list = new ArrayList<>();
	void add(T item) { list.add(item);}
	T get(int i) { return list.get(i);}
	int size() {return list.size();}
	public String toString() {return list.toString();}
}