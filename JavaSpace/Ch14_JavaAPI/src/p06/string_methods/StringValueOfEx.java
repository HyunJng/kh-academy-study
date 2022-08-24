package p06.string_methods;

// String.valueof() : primitive 타입을 문자열로 변환
public class StringValueOfEx {
	public static void main(String[] args) {
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(10.5);
		String str3 = String.valueOf(false);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		System.out.println(str1.length());
		System.out.println(str2.length());
		System.out.println(str3.length());
	}
}
