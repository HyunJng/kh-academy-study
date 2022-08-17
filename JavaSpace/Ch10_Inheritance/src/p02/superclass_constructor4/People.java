package p02.superclass_constructor4;

public class People {
	public String name;
	public String ssn;
	
	public People() {
		System.out.println("parent - default constructor");
	}

	public People(String name, String ssn) {
		this(); 
		this.name = name;
		this.ssn = ssn;
	}
	
}
