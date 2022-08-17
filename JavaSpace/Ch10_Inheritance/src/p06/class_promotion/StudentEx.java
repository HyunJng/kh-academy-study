package p06.class_promotion;

public class StudentEx {
	public static void main(String[] args) {
	
		Person p;
		Student s = new Student("홍길동");
		s.printPersonInfo();
		s.printStudentInfo();
		
		p = s;	// promotion 발생(자동 형변환)
		p.printPersonInfo();
//		p.printStudentInfo();
		
		Student s2 = null;
		if(p instanceof Student)
			s2 = (Student)p;
		s2.printStudentInfo();
	}
}
