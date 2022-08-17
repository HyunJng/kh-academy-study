package p02.superclass_constructor2;

public class ConstructorEx {
	public static void main(String[] args) {
		//Child c1 = new Child();

		Child c2 = new Child(11);
		
		System.out.println("집 전화번호:" + c2.homePhoneNumber);
		c2.printParentInfo();
	}
}

