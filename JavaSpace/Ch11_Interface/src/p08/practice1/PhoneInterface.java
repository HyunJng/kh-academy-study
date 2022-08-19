package p08.practice1;

public interface PhoneInterface {
	int TIMEOUT = 10000;
	
	void sendCall();
	void recieveCall();
	
	default void printLogo() {
		System.out.println("** Phone **");
	}
	
}
