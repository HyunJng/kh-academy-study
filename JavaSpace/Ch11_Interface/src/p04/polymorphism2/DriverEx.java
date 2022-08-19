package p04.polymorphism2;

public class DriverEx {
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Vehicle v = new Bus();	// promotion발생
		
		driver.driver(v);	// polymorphism
	}
}
