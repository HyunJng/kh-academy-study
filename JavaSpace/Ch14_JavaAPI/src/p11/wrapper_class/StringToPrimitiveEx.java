package p11.wrapper_class;

//String 을 primitive type값으로 변환하는 library (Wrapper class 내에 존재)
public class StringToPrimitiveEx {
	public static void main(String[] args) {
		int a = Integer.parseInt("10");
		double d = Double.parseDouble("3.14");
		boolean b = Boolean.parseBoolean("true");
		String s = String.valueOf(a);
		
		System.out.println(a);
		System.out.println(d);
		System.out.println(b);
		System.out.println(s);
		
	}
}
