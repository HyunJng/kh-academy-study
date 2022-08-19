package p03.default_static_method;

public class RemoteControlEx {
	public static void main(String[] args) {

		RemoteControl rc;
		
		
		rc = new Television();
		rc.turnOn();	
		rc.setMute(true);
		rc.setVolume(7);
		rc.setMute(false);
		rc.turnoff();

		RemoteControl.changeBattery();
		System.out.println();
		
		rc = new Audio();
		rc.turnOn();	
		rc.setMute(true);
		rc.setVolume(7);
		rc.setMute(false);
		rc.turnoff();
		
		RemoteControl.changeBattery();
	}
}
