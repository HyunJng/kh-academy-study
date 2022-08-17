package p05.prected_acces_modifier.pkg1;

public class B{
	
	public void method() {
		A a = new A();
		a.field = "newValue";
		a.method();
	}
}
