package collection;

import java.util.*;

public class HashMapEx2 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		
		map.put("김자바", new Integer(100));
		map.put("이자바", new Integer(100));
		map.put("강자바", new Integer(80));
		map.put("안자바", new Integer(90));
		
		Set set = map.entrySet();	// iterator을 사용하기 위해 Set형태로 바꿔줌.
		Iterator it =  set.iterator();

		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();	//다시 entry형태로 봐야하기 떄문에 바꿔줌<<왜?
			System.out.println("이름 : "+entry.getKey() + ", 점수 : "+ entry.getValue());
			// map에서는 key를 이용해 value를 찾거나, key나 value를 통째로 가져오는건 할 수 있지만
			// value나 key를 하나하나 갖고 오는 것은 불가능하기에 entry로 바꿔서 함
		}
		
		set = map.keySet();
		System.out.println("참가자 명단 : "+ set);
		
		Collection values = map.values(); // 모든 value값들 반환
		it = values.iterator();
		
		int total = 0;
		while(it.hasNext()) {
			Integer i = (Integer)it.next();//Collection형으로 반환했으므로 형변환해야함.
			total += i.intValue();
		}
		
		System.out.println("총점: "+ total);
		System.out.println("평균: "+ (float)total/set.size());
		System.out.println("최고점수: "+ Collections.max(values));
		System.out.println("최저점수: "+ Collections.min(values));
		
	}
}
