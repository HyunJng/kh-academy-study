package p01.basic;

public class RemoteControlEx {
	public static void main(String[] args) {

		RemoteControl rc;
		
		rc=new Television();
//		rc = new Audio();// promotion

		rc.turnOn();	// polymorphism
		rc.setVolume(7);
		rc.turnoff();
	}
}
