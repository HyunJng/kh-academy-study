package p02.multi_type_generic;

// Generic type으로 T, V를 사용하겠다는 의미(generic multi type)
// - generic type뿐만 아니라, 일반 primitive나 다른 클래스들도 사용 가능
// - 대부분의 class들은 최대 3개까지만 generic타입을 사용.
public class Product<T, V> {
	private T kind;
	private V model;
	private int id;
	
	public T getKind() {
		return kind;
	}
	
	public void setKind(T kind) {
		this.kind = kind;
	}
	
	public V getModel() {
		return model;
	}
	
	public void setModel(V model) {
		this.model = model;
	}
}
