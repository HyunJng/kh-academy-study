package p01.basic2;

public interface Phone {
	public static final int TIMEOUT = 10000;
	
	public abstract void sendCall();
	public abstract void recieveCall();
}
