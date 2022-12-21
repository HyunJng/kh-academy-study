package p012.coupling.factory_pattern;


public class TVUser {
	// 삼성 TV, LgTV 를 사용할 수 있다.
	public static void main(String[] args) {
		TV tv = (TV) (new BeanFactory()).getBean(args[0]);
		tv.powerOn();	// polymorphism
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}
