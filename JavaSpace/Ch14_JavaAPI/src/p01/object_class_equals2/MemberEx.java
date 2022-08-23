package p01.object_class_equals2;

import java.util.HashSet;
import java.util.Set;

public class MemberEx {
	public static void main(String[] args) {
		Member m1 = new Member("hong");
		Member m2 = new Member("hong");
		Member m3 = new Member("kim");
		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());
		
		if(m1.equals(m2)) {
			System.out.println("m1과 m2가 동일한 멤버입니다.");
		}else {
			System.out.println("m1과 m2가 동일한 멤버가 아닙니다.");
		}

		if(m1.equals(m3)) {
			System.out.println("m1과 m3가 동일한 멤버입니다.");
		}else {
			System.out.println("m1과 m3가 동일한 멤버가 아닙니다.");
		}
		
		//////////////////////////
		Set<Member> members = new HashSet<Member>();
		members.add(m1);
		members.add(m2);
		members.add(m3);
		members.add(new Member("Kang"));
		
		System.out.println(members);
	}
}
