package p03.generic_method;

public class GenericMethodEx {
	public static void main(String[] args) {
//		Box<Integer> b1 = Util.<Integer>boxing(100); 
		Box<Integer> b1 = Util.boxing(100);// Integer 추정 가능하여 생략
		
		int i1 = b1.getT();
		System.out.println(i1);
		
		Box<String> s1 = Util.boxing("홍길동");
		String name = s1.getT();
		
		System.out.println(name);
		
	}
}
