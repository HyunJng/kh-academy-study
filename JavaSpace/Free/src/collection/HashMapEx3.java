package collection;

import java.util.*;

public class HashMapEx3 {
	static HashMap phoneBook = new HashMap();
	
	public static void main(String[] args) {
		addPhoneNo("친구", "이자바", "000");
		addPhoneNo("친구", "rlawkqk", "111");
		addPhoneNo("친구", "김자바", "333");
		addPhoneNo("회사", "김대리", "444");
		addPhoneNo("회사", "김대리", "444");
		addPhoneNo("회사", "박대리", "666");
		addPhoneNo("회사", "이과장", "777");
		addPhoneNo("세탁", "888");
		
		printList();
	}
	
	static void addPhoneNo(String groupName, String name, String tel) {
		addGroup(groupName);
		HashMap group = (HashMap)phoneBook.get(groupName);
		group.put(tel, name);		
	}
	
	static void addPhoneNo(String name, String tel) {
		addPhoneNo("기타", name, tel);
	}
	
	static void addGroup(String groupName) {
		if(!phoneBook.containsKey(groupName))
			phoneBook.put(groupName, new HashMap());
	}
	
	static void printList() {
		Set set = phoneBook.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next(); 
			Set subSet = ((HashMap)e.getValue()).entrySet();
			Iterator subIt = subSet.iterator();
			
			System.out.println("*"+ e.getKey() + "["+subSet.size() +"]");
			while(subIt.hasNext()) {
				Map.Entry subE = (Map.Entry)subIt.next();
				System.out.println("이름"+(String)subE.getKey() + ", 번호: "+ (String)subE.getValue());
			}
			System.out.println();
		}
		
	}
}
