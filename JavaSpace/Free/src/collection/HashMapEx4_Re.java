package collection;

import java.util.*;

public class HashMapEx4_Re {
	public static void main(String[] args) {
		String[] data = { "A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D" };

		HashMap map = new HashMap();

		for (int i = 0; i < data.length; i++) {
			if(!map.containsKey(data[i])) {
				map.put(data[i], Integer.valueOf(1));
			}else {
				int value = ((Integer)map.get(data[i])).intValue();
				map.put(data[i], (Integer) (value + 1));
			}
		}
		
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next(); 
			int value = (int)e.getValue();
			System.out.println(e.getKey() + " : "+ print('❤', value)+ value);
		}
		
		
	}
	
	public static String print(char ch, int num) {
		char[] bar = new char[num];
		for(int i = 0; i < bar.length ;i++) {
			bar[i ] = ch;
		}
		
		return new String(bar) +" ";
	}
}
