package p03.linkedlist;

import java.util.*;

// 1. LinkedList는 원소가 빈번히 추가, 삭제되는 application에 사용하는 것을 권장
// 		- 예: 증권 주식 주문(증구너 어플리케이션)
// 2. ArrayList는 원소가 빈번히 추가, 삭제되면 속도가 느려지는 단점이 있다.
//		- 원소 생성 후 조회가 많은 application에서 사용하는 것을 권장. (박물관 시스템, 도서관시스템)
// 		- vector보다는 ArrayList가 처리 속도가 일반적으로 빨라 ArrayList를 사용하길 권장. 
public class LinkedListEx {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		
		long startTime = System.nanoTime();
		long endTime;
		
		
		for(int i = 0; i<10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList 소요시간: " + (endTime - startTime) + "ns");
		
		
		
		startTime = System.nanoTime();
		
		for(int i = 0; i<10000; i++) {
			list2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList 소요시간: " + (endTime - startTime) + "ns");
	}
}
