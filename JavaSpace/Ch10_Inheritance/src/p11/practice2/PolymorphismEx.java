package p11.practice2;

public class PolymorphismEx {

	public static void main(String[] args) {
		displayObject(new Circle("red", false, 1));
		displayObject(new Rectangle("blue", true, 3, 4));
		
		DummyClass dummy = new DummyClass();
		System.out.println(dummy);
	}
	//parameter에서 polymorphism 발생
	public static void displayObject(GeometricObject geoObj) {
		System.out.println("Object 정보 : "+ geoObj);
		System.out.println();
	}
}
