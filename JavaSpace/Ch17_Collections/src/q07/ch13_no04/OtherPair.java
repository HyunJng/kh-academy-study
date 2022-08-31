package q07.ch13_no04;

public class OtherPair<K, V> {
	private K key;
	private V value;

	public OtherPair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	protected K getKey() {
		return key;
	}

	protected V getValue() {
		return value;
	}
}
