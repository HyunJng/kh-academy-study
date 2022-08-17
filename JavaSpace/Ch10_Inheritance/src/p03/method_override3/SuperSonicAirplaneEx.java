package p03.method_override3;

public class SuperSonicAirplaneEx {
	public static void main(String[] args) {
		SuperSonicAirplane s = new SuperSonicAirplane();
		
		s.takeOff();
		s.fly();
		s.flyMode = SuperSonicAirplane.SUPERSONIC;
		s.fly();
		s.flyMode = SuperSonicAirplane.NORMAL;
		s.fly();
		s.land();
	}
}
