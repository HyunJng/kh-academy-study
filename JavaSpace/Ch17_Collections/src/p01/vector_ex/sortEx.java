package p01.vector_ex;

import java.util.*;

class Student{
	String name;
	int classNo;
	
	Student(String name, int classNo){
		this.name = name;
		this.classNo = classNo;
	}
	
	@Override
	public String toString() {
		return "(" + name + " " + classNo +")";
	}
}

public class sortEx {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		
		list.add(new Student("김", 1));
		list.add(new Student("박", 1));
		list.add(new Student("사", 3));
		list.add(new Student("자", 5));
		list.add(new Student("랑", 4));
		list.add(new Student("샤", 0));
		
		System.out.println(list);

		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.classNo - o2.classNo;
			}
		});
		
		System.out.println(list);
		
	}
	
}
