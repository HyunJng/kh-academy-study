package p02.ArrayList_collections_class;

import java.util.*;

public class CollectionsClassEx {
	public static void main(String[] args) {
		Integer[] numbers = {1123, 1412, 23, 44, 5121232};
		List<Integer> list = Arrays.asList(numbers);
		
		System.out.println(Collections.max(list));
		System.out.println(Collections.min(list));
		System.out.println(Collections.binarySearch(list, 44));
		
		System.out.println("원본: " + list);
		
		Collections.sort(list);
		System.out.println("sort: "+list);
		
		Collections.reverse(list);
		System.out.println("reverse: "+list);
		
		Integer[] numbrs1 = {121, 23532, 123, 1, 41234};
		List<Integer> list1 = Arrays.asList(numbrs1);
		
		System.out.println(Collections.disjoint(list, list1));	// 겹치는게 없으면 true
	}
}
