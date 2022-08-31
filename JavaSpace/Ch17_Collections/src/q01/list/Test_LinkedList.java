package q01.list;

import java.util.*;
public class Test_LinkedList {
	public static void main(String[] args) {
		List<Character> list = new LinkedList<Character>();
		
		list.add(new Character('a'));
		list.add(new Character('b'));
		list.add(new Character('c'));
		
		for(int i = 0; i<list.size(); i++)
			System.out.print(list.get(i) + "\t");
		
		System.out.println();
		
		list.forEach((i)->System.out.print(i + "\t"));
		
	}
}
