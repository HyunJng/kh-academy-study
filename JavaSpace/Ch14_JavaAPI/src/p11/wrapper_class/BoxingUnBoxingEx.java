package p11.wrapper_class;

public class BoxingUnBoxingEx {
	public static void main(String[] args) {
		//Boxing
		Integer obj1 = new Integer(100);
		Integer obj2 = new Integer("200");
		Integer obj3 = new Integer("300");
		
		//Unboxing
		int i1 = (int)obj1;
		int i2 = obj2.intValue();
		int i3 = obj3.intValue();
		
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		
		//Boxing
		Double obj4 = new Double(100.3);
		Double obj5 = new Double("200.45");
		Double obj6 = new Double("300.12");
		
		//Unboxing
		double d1 = obj4.doubleValue();
		double d2 = obj5.doubleValue();
		double d3 = obj6.doubleValue();
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
	}
}
