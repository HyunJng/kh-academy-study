package p01.basic;

//문자열에서 특정 문자를 가져오는 방법 - charAt(int index)

public class StringBasic3 {
	public static void main(String[] args) {
		String message = "Welcom to Java ";
		int len = message.length();
		
		char firstChar = message.charAt(0);
		char thirdChar = message.charAt(2);
		char lastChar = message.charAt(len - 1);
		
		System.out.println(len);
		System.out.println(firstChar);
		System.out.println(thirdChar);
		System.out.println(lastChar);
		
		for(int i = 0; i<len ; i++) {
			System.out.println(i+"번째 문자는 " + message.charAt(i));
		}
		

		System.out.println(message.trim());
		System.out.println(message.trim().length());
	}
}
