package p03.datatypes_promotion;

public class PromotionEx {
	public static void main(String args[]) {
		byte byteValue = 10;
		int intValue = byteValue;		
		System.out.println("intValue = " + intValue);
		
		char charValue = '가';
		intValue = charValue;		
		System.out.println("intValue = " + intValue);
		
		intValue = 500;
		
		long longValue = intValue;		
		System.out.println("longValue = " + longValue);
		
		float floatValue = longValue;
		System.out.println("floatValue = " + floatValue);
		
		double doubleValue = longValue;		
		System.out.println("doubleValue = " + doubleValue);
	}
}
