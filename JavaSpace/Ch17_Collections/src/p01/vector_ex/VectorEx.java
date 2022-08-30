package p01.vector_ex;

import java.util.*;

// list data type의 특징
// 1. 원소 추가할 때 기본적으로 맨 마지막 우너소 다음에 넣음
// 2. 원소를 삭제하면, 해당 원소 자리의 다음에 있는 원소가 하나씩 땡겨서 중간에 비어있는 자리가 없음.
public class VectorEx {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
//		List<Integer> v = new Vector<Integer>();

		v.add(5);
		v.add(4);
		v.add(-1);

		System.out.println(v);
		System.out.println();

		v.add(1, 100); // index = 1위치에 끼어넣기

		System.out.println(v);
		System.out.println("전체 원소 갯수 : " + v.size());
		System.out.println("vector의 전체 크기 : " + v.capacity());
		System.out.println();

		for (int i = 0; i < 10; i++)
			v.add(i + 10);

		System.out.println(v);
		System.out.println("전체 원소 갯수 : " + v.size());
		System.out.println("vector의 전체 크기 : " + v.capacity());
		System.out.println();

		// collection :향상된 for문 사용 적극 권장
		for (Integer i : v) {
			System.out.println("원소 : " + i);
		}
	}
}
