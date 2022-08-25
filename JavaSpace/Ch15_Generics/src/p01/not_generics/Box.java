package p01.not_generics;

public class Box {
	Object[] object = new Object[10];
	static int i = 0;
	void setObject(Object obj) {
		object[i] = obj;
		i++;
	}
	
	Object getObject() {
		return object[i - 1];
	}
}
