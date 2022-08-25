package p02.multi_type_generic;

class TV {}
class Car{}

public class ProductEx {
	public static void main(String[] args) {
		Product<TV, String> p1= new Product<>();
		p1.setKind(new TV());
		p1.setModel("스마트 TV");
		TV tv = p1.getKind();
		String tvModel = p1.getModel();
		
		Product<Car, String> p2 = new Product<Car, String>();
		p2.setKind(new Car());
		p2.setModel("디젤자동차");
		Car car = p2.getKind();
		String carModel = p2.getModel();
		
		
		
	}
}
