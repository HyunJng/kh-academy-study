package p08.polymorphism3;

public class DriverEx {
	public static void main(String[] args) {
		Driver driver = new Driver();
		Vehicle v = new Bus();
		driver.drive(v);
		

		Bus bus = new Bus();
		driver.drive(bus);
		driver.drive(new Sedan());
		driver.drive(new Taxi());
	}
}
