package lamda;

import java.util.*;

public class LamdaEx4 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 10; i > 0; i--)
			list.add(i);
		// 모든 요소를 출력 ( i에는 list에 저장된 값을 하나씩 대입)
		System.out.print("list.forEach의 결과: ");
		list.forEach(i -> System.out.print(i + ","));//consumer : 매개변수 O, return X
		
		// list의 2또는 3의 배수를 제거
		list.removeIf(x-> x%2 == 0 || x%3 == 0);
		System.out.print("\nremoveIf의 결과: "+list);
		
		// list의 각 요소에 10을 곱함
		list.replaceAll(i -> i * 10);
//		list.forEach(i -> i * 10);	// 안되는 이유: forEach에는 다시 넣어주는 기능은 없기 떄문.
		System.out.print("\nreplaceAll의 결과: "+list);
		
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		
		//map의 모든 요소를 {k, v} 형식으로 출력
		System.out.print("\nmap.forEach의 결과: ");
		map.forEach((i, j) -> System.out.print("{" + i + ", " + j + "}, "));
	}
}
