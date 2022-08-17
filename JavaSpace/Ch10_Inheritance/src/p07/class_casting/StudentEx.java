package p07.class_casting;


public class StudentEx {
	public static void main(String[] args) {
	
		Person p;
		Student s = new Student("홍길동");
		s.printPersonInfo();
		s.printStudentInfo();
		
		p = s;
		p.printPersonInfo();
		
		Student s2 = null;
		if(p instanceof Student)
			s2 = (Student)p;	// down casting 
		s2.printStudentInfo();
		
		Person p2 = new Person("홍길동");
		s = (Student) p2;
		s.printPersonInfo();
		s.printStudentInfo(); // runtime error(Exception) 발생
		
	}
}

	