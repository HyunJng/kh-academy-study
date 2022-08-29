package p05.restricted_generic;

import java.util.Arrays;

// <?> <? extends> <? super> 은 method generic에서만 사용 가능.
public class RestrictedGeneircEx {
	public static void main(String[] args) {
		Course<Person> personCourse = new Course<Person>("일반인과정", 5);
		personCourse.add(new Person("일반인"));	// person의 자식이라 가능
		personCourse.add(new Worker("직장인"));
		personCourse.add(new Student("학생"));
		personCourse.add(new HighStudent("고등학생"));
		
		Course<Worker> workerCourse = new Course<Worker>("직장인과정", 5);
//		workerCourse.add(new Person("일반인"));	// worker가 아니기 때문에 안됨
		workerCourse.add(new Worker("직장인"));
//		workerCourse.add(new Student("학생"));
//		workerCourse.add(new HighStudent("고등학생"));
		
		Course<Student> studentCourse = new Course<Student>("학생과정", 5);
//		studentCourse.add(new Person("일반인"));	//student와 highstudent만 됨
//		studentCourse.add(new Worker("직장인"));
		studentCourse.add(new Student("학생"));
		studentCourse.add(new HighStudent("고등학생"));
		
		Course<HighStudent> highstudentCourse = new Course<HighStudent>("고등학생과정", 5);
//		studentCourse.add(new Person("일반인"));	//highstudent만 됨
//		studentCourse.add(new Worker("직장인"));
//		highstudentCourse.add(new Student("학생"));
		highstudentCourse.add(new HighStudent("고등학생"));
		
		registrerCourse(personCourse);	// 어떤 제네릭 타입이든 가능.
		registrerCourseStudent(studentCourse); 	// Students의 자식만 가능.
		registrerCourseStudent(highstudentCourse);
		registrerCourseWorker(workerCourse); 	// Worker의 부모만 가능
		registrerCourseWorker(personCourse);
		
	}
	
	public static void registrerCourse(Course<?> course) {
		System.out.println(course.getName() + "수강생: "+ Arrays.toString(course.getStudents()));
	}
	public static void registrerCourseStudent(Course<? extends Student> course) {
		System.out.println(course.getName() + "수강생: "+ Arrays.toString(course.getStudents()));
	}
	public static void registrerCourseWorker(Course<? super Worker> course) {
		System.out.println(course.getName() + "수강생: "+ Arrays.toString(course.getStudents()));
	}
}
