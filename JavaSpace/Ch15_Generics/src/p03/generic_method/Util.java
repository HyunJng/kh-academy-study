package p03.generic_method;

// <T> Box<T> boxing(T t)
// 1. <T>: method안에서 T를 data type으로 사용
// 2. Box<T> : return 타입
// 3. boxing(T t) : T를 data type으로 하는 parameter을 받음.
public class Util {
	
//			<Integer>        boxing(Integer(100))
	public static <T> Box<T> boxing(T t){
		Box<T> box = new Box<T>();
		box.setT(t);
		
		return box;
	}
}
