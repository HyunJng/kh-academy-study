package p08.practice1;

public class MultiInterfaceEx {
	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone();

		sp.printLogo();
		sp.sendCall();
		sp.play();
		System.out.println("3 + 5 = " + sp.calculate(3, 5));
		sp.schedule();
		sp.recieveCall();
		sp.receiveSNS();
		sp.stop();
	}
}
