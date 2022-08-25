package p10.arrays_method2;

import java.util.Comparator;

public class Member implements Comparable<Member> {
	String name;
	
	public Member(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(Member o) {
		return - name.compareTo(o.name);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
