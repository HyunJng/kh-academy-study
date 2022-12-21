package p401.di.annotation;
// interface에는 @Component 로 지정할 수 없다. 
public interface TV {
	public void powerOn();

	public void powerOff();

	public void volumeUp();

	public void volumeDown();
}
