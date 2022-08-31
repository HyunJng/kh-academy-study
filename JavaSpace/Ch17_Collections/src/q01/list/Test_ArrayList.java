package q01.list;

import java.util.*;

public class Test_ArrayList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("복숭아");
		list.add("포도");
		list.add("참외");
		list.add("사과");
		list.add("바나나");
		list.add("키위");
		list.add("포도");
		list.add("포도");
		
		System.out.println("요소개수 : "+ list.size());
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println();
		
	}
}
