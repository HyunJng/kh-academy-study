package q04.hashmap;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.CountDownLatch;
public class TestHashMap {
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 10개를 입력하시오.");
		for(int i = 0; i < 10; i++)
			inputMap(sc.nextInt());
		
		int max = 0;
		int key = 0;
//		방법 1
		for(int k : map.keySet()) {
			if(max < map.get(k)) {
				key = k;
				max = map.get(k);
			}
		}
		Set<Integer> set = map.keySet();
		set.forEach(null);
//  	방법 2		
//		max = 0;
//		key = 0;
//		Set<Entry<Integer, Integer>> set = map.entrySet();
//		Iterator<Entry<Integer, Integer>> it = set.iterator();
//		while(it.hasNext()) {
//			Entry<Integer, Integer> entry = it.next();
//			int value = entry.getValue(); 
//			if(max < value) {
//				max = value;
//				key = entry.getKey();
//			}
//		}
		
		
		System.out.println("가장 많이 입력된 정수는 " + key +", 횟수는 " + max);
		System.out.println(map.keySet());
		System.out.println(map.values());
	}
	
	public static void inputMap(int s) {
		if(map.containsKey(s)) {
			Integer key = map.get(s);
			map.put(Integer.valueOf(s), ++key);
		}else {
			map.put(Integer.valueOf(s), 1);
		}
	}
}
