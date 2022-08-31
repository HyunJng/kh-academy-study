package q03.arraylist;

import java.util.*;
public class TestArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("list1에 들어갈 정수 10개 입력하시오.");
		for(int i = 0; i<10; i++)
			list1.add(sc.nextInt());
		System.out.println("list2에 들어갈 정수 10개 입력하시오.");
		for(int i = 0; i<10; i++)
			list2.add(sc.nextInt());
		
		System.out.println("중복을 허용하지 않은 합집합");
		System.out.println(removeDuplicate(list1, list2));
	}
	
	// 중복 비허용
	public static ArrayList<Integer> removeDuplicate(ArrayList<Integer> list1, ArrayList<Integer> list2){
		Set<Integer> set = new HashSet<Integer>();
		
		set.addAll(list1);
		set.addAll(list2);
		
		return new ArrayList<Integer>(set);
	}
}
