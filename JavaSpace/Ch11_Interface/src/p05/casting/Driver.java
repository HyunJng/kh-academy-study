package p05.casting;

public class Driver {
	
	//method parameter의 data type으로 Interface를 사용할 수 있음.
	public void driver(Vehicle vehicle) {
		vehicle.run();
	}
}
