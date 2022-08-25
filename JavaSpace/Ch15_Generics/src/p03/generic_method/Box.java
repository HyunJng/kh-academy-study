package p03.generic_method;

public class Box <T>{
	//<String>으로 고정하면
	
	//private String t;
	private T t;
	
	//public void set(String t)
	public void setT(T t) {
		this.t = t;
	}
	// public String get()
	public T getT() {
		return t;
	}
}
