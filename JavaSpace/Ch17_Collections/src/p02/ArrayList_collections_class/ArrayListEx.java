package p02.ArrayList_collections_class;

import java.util.*;


//List계열 collection
// 1. 원소 값이 동일하더라도 중복 저장
// 2. index, 원소 값으로 삭제 가능
//	 - 삭제할 때, 뒤에 있는 원소가 자동으로 삭제된 원소 위치로 이동
//	 - index로 삭제할 원소가 없으면 Exception 발생
public class ArrayListEx {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("JAVA");
		list.add("JAVA");
		list.add("jdbc");
		list.add("ijdbc");
		list.add("wijdbc");
		
		System.out.println(list);
		
		list.remove(2);
//		list.remove(10); // error IndexOutOfBoundsException
		list.remove("JAVA");
		list.remove("ㅏ");	// error 안남. 
		System.out.println(list);
	}
}
