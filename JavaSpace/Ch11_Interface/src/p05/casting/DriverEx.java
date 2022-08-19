package p05.casting;

public class DriverEx {
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Vehicle v = new Bus();	// promotion발생

//		v.checkFare();
		
		if(v instanceof Bus) {	// 이렇게 쓰는 것이 바람직하지는 않음.
			Bus bus = (Bus)v;
			bus.checkFare();
		}
			
	}
}
