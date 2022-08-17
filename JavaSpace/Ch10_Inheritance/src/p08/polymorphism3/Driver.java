package p08.polymorphism3;

public class Driver {

	// method parameter에서 promotion발생
	public void drive(Vehicle vehicle) {
		vehicle.run();	// override여서 polymorphism 발생
	}
}
