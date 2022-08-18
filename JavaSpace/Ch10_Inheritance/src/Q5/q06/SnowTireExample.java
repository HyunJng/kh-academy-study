package Q5.q06;

public class SnowTireExample {
	public static void main(String[] args) {
		SnowTire snowTire = new SnowTire();
		Tire tire = new Tire();
		
		snowTire.run(); //스노우타이어 굴러갑니다.
		tire.run();	// 일반타이어가 굴러갑니다.
	}
}
