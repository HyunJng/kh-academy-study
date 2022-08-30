package p05.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * map에 entry 추가
 - key가 중복되더라고 에러 발생 없음, value는 최종적으로 저장함 값을 갖음.
 */
public class HashMapEx2 {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("홍길동", 80);
		map.put("홍길동", 95);
		map.put("홍길동", 75);

		System.out.println("총 entry 수 : " + map.size());
		System.out.println("홍길동 점수 : " + map.get("홍길동"));
		
		System.out.println();

		map.remove("신용권");

		// map원소 검색 방법 4가지
		// 방법 1 : Set 변환 후 Iterator - while문 이용
		Set<String> ketSet = map.keySet(); 
		Iterator<String> keyIt = ketSet.iterator();
		while (keyIt.hasNext()) {
			String key = keyIt.next();
			Integer value = map.get(key);
			System.out.println("key : " + key + " , value : " + value);
		}
		System.out.println();

		// 방법 2 (상향된 for문)
		for (String key : map.keySet()) {
			Integer value = map.get(key);
			System.out.println("key : " + key + " , value : " + value);
		}
		System.out.println();

		// 방법 3 (entrySet을 통한 key, value 가져오는 방법)
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIt = entrySet.iterator();
		while (entryIt.hasNext()) {
			Map.Entry<String, Integer> entry = entryIt.next();
			String key = entry.getKey();
			Integer value = map.get(key);
			System.out.println("Key : " + key + " , Value : " + value);
		}
		System.out.println();

		// 방법 4 (lambda expression 사용) : java 1.8 지원
		// forEach 메소드의 parameter로 람다 익명객체 넘김.
		map.forEach((key, value) -> {
			System.out.println("key : " + key + " , value : " + value);
		});
		
		System.out.println();

		map.clear();
		System.out.println("총 entry 수 : " + map.size());
	}
}