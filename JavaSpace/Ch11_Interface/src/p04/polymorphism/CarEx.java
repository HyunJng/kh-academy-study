package p04.polymorphism;

public class CarEx {
	public static void main(String[] args) {
		
		Car car = new Car();
		
		car.run();
		
		System.out.println();
		
		car.frontLeftTire = new KumhoTire();
		car.frontRightTire = new KumhoTire();
		
		car.run();

	}
}
