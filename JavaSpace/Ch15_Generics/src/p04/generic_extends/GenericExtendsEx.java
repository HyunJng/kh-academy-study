package p04.generic_extends;

public class GenericExtendsEx {
	public static void main(String[] args) {
//		int resut = Util.compare("a", "b");
		
		int result = Util.compare(10, 20);
		System.out.println(result);
		
		result = Util.compare(11.4, 11.4);
		System.out.println(result);
	}
}
