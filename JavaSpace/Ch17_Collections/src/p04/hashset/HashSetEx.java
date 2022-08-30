package p04.hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
Set collection
- 중복된 원소를 저장하지 않음
- 모든 원소가 중복되지 않아야하는 application에서 사용함.
  - 회사 내 사원 관리, 
 */
public class HashSetEx {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servelt/JSP");
		set.add("Java");	// 중복된 원소 삭제
		set.add("iBatis");
		
		int size = set.size(); // 중복된 원소를 삭제한 후, size 측
		System.out.println("총인원수 : "+size);	//--> 총인원수 : 4
		
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String e = it.next();
			System.out.println(e);
		}
		
		System.out.println();
		
		for (String e : set) {
			System.out.println(e);
		}
	}
	
}