package p02.superclass_constructor4;

public class StudentEx {
	public static void main(String[] args) {
		Student s = new Student("홍길동", "1234567-1234567", 1);
		
		System.out.println("이름: "+ s.name);
		System.out.println("주민등록번호: "+ s.ssn);
		System.out.println("학생 번호: "+ s.studentNo);
		
		s.equals(s);
	}
}
