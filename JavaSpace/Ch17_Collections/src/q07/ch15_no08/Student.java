package q07.ch15_no08;

import java.util.Objects;

public class Student {
	public int studentNum;
	public String name;
	
	public Student(int studentNum, String name) {
		this.studentNum = studentNum;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentNum);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;
		if(obj instanceof Student) {
			Student other = (Student) obj;
			return other.studentNum == studentNum;
		}
		return false;
	}
	
}
