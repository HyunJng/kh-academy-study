package lamda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Person {
	String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
}

public class Free {

	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("김"));
		list.add(new Person("홍"));
		list.add(new Person("길"));
		list.add(new Person("동"));

		Comparator<Person> cmpPerson = new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return (o1.name.charAt(0) - o2.name.charAt(0));
			}

		};

		System.out.println(list);
		Collections.sort(list, cmpPerson);
		System.out.println(list);
	}

}
