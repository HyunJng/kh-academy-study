package p01.basic3;

public class MyFunctionalInterfaceEx {
	public static void main(String[] args) {
		MyFunctionalInterface m1= (x) -> {
			return x * x;
		};
		
		System.out.println(m1.method(5));
		
		m1 = x-> x*x;
		System.out.println(m1.method(3));
		
		
	}
}
