package p06.generic_inheritance;

// Storage<T> : 부모
// StorageImpl<T> : 자식
// >> generic 타입도 부모 자식간에 상속할 수 있다.
public class StorageImpl<T> implements Storage<T>{
	private T[] array;
	
	public StorageImpl(int capacity) {
		this.array = (T[]) new Object[capacity];
	}
	
	@Override
	public void add(T item, int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
