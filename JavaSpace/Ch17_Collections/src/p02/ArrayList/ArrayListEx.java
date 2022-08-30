package p02.ArrayList;

import java.util.*;

public class ArrayListEx {
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		
		for(int i = 0; i<4; i++) 
			a.add((char)(i +'A') + "길동");
		
		// 기본 for문
		for(int i = 0; i<a.size(); i++)
			System.out.println(a.get(i));
		System.out.println();
		
		// 향상된 for문
		for(String k : a)
			System.out.println(k);
		System.out.println();
		
		// iterator사용
		Iterator<String> it = a.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
}
