package p06.string_methods;

public class ByteToStringEx {
	public static void main(String[] args) {
//		byte[] bytes = new byte[] {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};// ASCII 코드값
		byte[] bytes = new byte[] {'H', 'e', 'l', 'l', 'o', ' ', 'J', 'a', 'v', 'a'};
		String str1 = new String(bytes);
		System.out.println(str1);
		
		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);
	}
}
