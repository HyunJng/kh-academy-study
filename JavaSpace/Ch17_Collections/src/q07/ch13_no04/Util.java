package q07.ch13_no04;

public class Util {
	// (매개로 Pair과 하위타입, 키값)
	static <K, V> V getValue(Pair<K, V> p, K k){
		if(p.getKey().equals(k))
			return (V) p.getValue();
		return null;
	}
}
