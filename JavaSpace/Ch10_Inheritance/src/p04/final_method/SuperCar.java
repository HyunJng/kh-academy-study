package p04.final_method;

public class SuperCar extends Car{
	
	@Override
	public void speedUp() {
		speed += 10;
	}
	
	public void speedDown() {
		if(speed >= 10)
			speed -= 10;
	}

}
