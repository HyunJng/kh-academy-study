package q07.ch15_no09;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MapEx {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name = null;
		int maxScore = 0;
		int totalScore = 0;
		Set<Entry<String, Integer>> set = map.entrySet();
		Iterator<Entry<String, Integer>> it = set.iterator();
		
		while(it.hasNext()) {
			Entry<String, Integer> entry = it.next();
			int score = entry.getValue();
			if(maxScore < score) {
				maxScore = score;
				name = entry.getKey();
			}
			totalScore += score;
		}
		
		System.out.println("평균점수 : " + (totalScore/map.size()));
		System.out.println("최고점수 : " + maxScore);
		System.out.println("최고점수를 받은 아이디 : " + name);
	}
}
