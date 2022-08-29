package p05.restricted_generic;

public class Course<T> {
	private String name;
	private T[] students;
	
	public Course(String name, int capacity) {
		this.name = name;
		this.students = (T[]) new Object[capacity];	// new로 인스턴스를 만들면 모든 field값은 null값이 setting
//		this.students = new T[capacity];	// 제너릭 타입의 배열은 안됨.
	}

	public String getName() {
		return name;
	}

	public T[] getStudents() {
		return students;
	}
	
	public void add(T t) {
		for(int i = 0; i<students.length; i++) {
			if(students[i] == null) {
				students[i] = t;
				break;
			}
		}
		
	}
}
