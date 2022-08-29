package p06.generic_inheritance;

public interface Storage<T> {
	
	void add(T item, int index);
	T get(int index);
}
