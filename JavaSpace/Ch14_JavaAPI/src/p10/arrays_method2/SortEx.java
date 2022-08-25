package p10.arrays_method2;

import java.util.Arrays;

// Arrays.sort(parameter: sorting한 array)
// 1. sorting할 array의 data type
//	- int[], char[] 등 primitive array 는 그대로 사용가능
//	- class로 지정된 array는 (String[], Member[]) comparable interface를 implement를 해야지만 사용 가능
// 2. a.compareTo(b)은 양의정수, 0, 음의정수 3가지로 return
//	- Arrays.sort()가 동작하는 방식
//		1. a < b : 음수를 return하고, Arrays.sort 가 a, b 순서 유지
//		2. a = b : 0 을 return하고, Arrays.sort 가 a, b 순서 유지
//		3. a > b : 양수를 return하고, Arrays.sort 가 a, b 순서를 b, a로 바꿈
// => compareTo(b)를 음수로 return 하도록 만들면 내림차순으로 변경
public class SortEx {
	public static void main(String[] args) {
		int[] scores = new int[]{ 99, 95, 44, 97, 98 };

		System.out.println(Arrays.toString(scores));
		Arrays.sort(scores);
		System.out.println(Arrays.toString(scores));
		
		System.out.println();
		
		String[] names = {"홍길동", "박동수", "김민수"};
		printArraysInfo(names);
		Arrays.sort(names);
		printArraysInfo(names);
		
		System.out.println();
		
		Member[] members = {new Member("홍길동"), new Member("박동수"), new Member("김동수")};
		printArraysInfo(members);
		Arrays.sort(members);
		printArraysInfo(members);
		
	}
	
	public static void printArraysInfo(Object[] members) {
		for (int i = 0; i < members.length; i++) {
			System.out.print(members[i] + " ");
		}
		System.out.println();
	}
}
