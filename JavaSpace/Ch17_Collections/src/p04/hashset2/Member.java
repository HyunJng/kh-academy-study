package p04.hashset2;

import java.util.Objects;

public class Member {
	public String name;
	public int age;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member member = (Member) obj;
			return name.equals(member.name) && (this.age == member.age);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		// String의 hashCode 값(문자열이 동일하면 hashCode 값도 동일) + 정수값
//		return name.hashCode() + age; 
		return Objects.hash(name, age);
	}
	
}