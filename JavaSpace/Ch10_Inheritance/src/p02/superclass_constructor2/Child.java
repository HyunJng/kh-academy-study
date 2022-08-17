package p02.superclass_constructor2;

public class Child extends Parent {

	public Child() {
		System.out.println("Child - default constructor 호출");
	}

	public Child(int homePhoneNumber) {
		// this.homePhoneNumber = homePhoneNumber;
		super(homePhoneNumber);
		System.out.println("Child - Child(int homePhoneNumber) constructor 호출");
	}

	public void printParentInfo() {
		super.name = "홍아버지";
		super.age = 55;

		System.out.println("Parent 이름: " + name + ", Parent 나이:" + age);
		super.dummyParent();
	}
}
