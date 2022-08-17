package p09.instanceof_basic;

class Person{}
class Student extends Person{}
class Researcher extends Person {}
class Professor extends Researcher {}

public class InstanceOfEx {
	public static void main(String[] args) {
		System.out.print("new Person Instance 결과 -> \t");
		printInstanceInfo(new Person());
		
		System.out.print("new Student Instance 결과 -> \t");
		printInstanceInfo(new Student());
		
		System.out.print("new Researcher Instance 결과 -> \t");
		printInstanceInfo(new Researcher());
		
		System.out.print("new Professor Instance 결과 -> \t");
		printInstanceInfo(new Professor());
	}
	// method parameter에서 promotion발생
	// A instanceof B => A: 인스턴스 , B: 클래스이름
	// - A 인스턴스의 힙메모리에 B class의 인스턴스가 존재하면 true, 아니면 false
	public static void printInstanceInfo(Person  p) {
		if(p instanceof Person)
			System.out.print("Person ");
		if(p instanceof Student)
			System.out.print("Student ");
		if(p instanceof Researcher)
			System.out.print("Researcher ");
		if(p instanceof Professor)
			System.out.print("Professor ");
		System.out.println();
	}
}
