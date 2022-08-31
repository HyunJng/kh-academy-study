package q02.arraylist;

import java.util.*;
public class TestArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("list1에 들어갈 정수 5개 입력하시오.");
		for(int i = 0; i<5; i++)
			list1.add(sc.nextInt());
		System.out.println("list2에 들어갈 정수 5개 입력하시오.");
		for(int i = 0; i<5; i++)
			list2.add(sc.nextInt());
		
		System.out.println("중복을 허용한 합집합");
		System.out.println(union(list1, list2));
	}
	
	// 중복 허용
	public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2){
		ArrayList<Integer> newList = new ArrayList<Integer>();
		
		newList.addAll(list1);
		newList.addAll(list2);
		
		return newList;
	}
}
