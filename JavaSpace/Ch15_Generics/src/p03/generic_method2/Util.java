package p03.generic_method2;

public class Util<K, V>{

	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		
		return keyCompare && valueCompare;
	}
	
//	public static boolean coe(Pair<K, V> p1, Pair<K, V> p2) {
//		return true;
//	}
	
//	public <K, V> boolean coe (Pair<K, V> p1, Pair<K, V> p2) {
//		return true;
//	}

}
