package p04.hashset2;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		
		// 원소들은 hashCode로 변환되어 저장함.
		Member m1 = new Member("홍길동", 30);
		Member m2 = new Member("홍길동", 30); // 중복된 원소 입력함.

		String name1 = "김길동";
		String name2 = "김길동";
		
		System.out.println(name1.hashCode());
		System.out.println(name2.hashCode());
		
		System.out.println("m1의 hashCode 리턴값 : " + m1.hashCode());
		System.out.println("m2의 hashCode 리턴값 : " + m2.hashCode());
		System.out.println("[패키지명.클래스명@힙메모리주소] : "+ m1); 
		System.out.println("[패키지명.클래스명@힙메모리주소] : "+ m2);
		
		set.add(m1);
		set.add(m2); 
		// hash code 값이 동일하면서, equals가 true이면 중복 저장하지 않음.

		System.out.println("총 원소수 : " + set.size());	//--> 총 원소수 : 1
		
		// +) @Override public int hashCode()를 각주처리 하면,--> 총 원소수 : 2		
	}
}