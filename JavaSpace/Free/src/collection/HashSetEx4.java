package collection;
import java.util.*;

public class HashSetEx4 {
	public static void main(String[] args) {
		HashSet set = new HashSet();
		
		set.add(new String("abc"));
		set.add(new String("abc"));
		set.add(new Person2("David", 10));
		set.add(new Person2("David", 10));
		
		System.out.println(set);
	}
	
}

class Person2{
	String name;
	int age;
	
	Person2(String name, int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person2) {
			Person2 temp = (Person2)obj;
			return name.equals(temp.name) && age == temp.age;
		}
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(name, age);
	}
	@Override
	public String toString() {
		return name +":"+age;		
	}
	
	

}
