package p03.reference_ex;

public class StringEqualEx {
	public static void main(String[] args) {
		String name = "null";
		String str1 = "신민철";
		String str2 = "신민철";

		int a = 10, b = 10;

		if (a == b)
			System.out.println("a, b값이 같다");
		else
			System.out.println("a, b값이 다르다" + "");

		if (str1 == str2)
			System.out.println("str1가 str2의 주소가 같음");
		else
			System.out.println("str1가 str2의 주소가 다음");

		if (str1.equals(str2))
			System.out.println("str1가 str2의 문자열이 같음");
		else {
			System.out.println("str1가 str2의 문자열이 다음");
		}
		
		str1 = "김민철"; // heap메모리에 김민철 생성
		String str3 = new String("신민철");
		String str4 = new String("신민철");

		if (str3 == str4)
			System.out.println("str3가 str4의 주소가 같음");
		else
			System.out.println("str3가 str4의 주소가 다음");

		if (str3.equals(str4))
			System.out.println("str3가 str4의 문자열이 같음");
		else {
			System.out.println("str3가 str4의 문자열이 다음");
		}
		
		System.out.println("str1 힙메모리 주소 : "+ System.identityHashCode(str1));
		System.out.println("str2 힙메모리 주소 : "+ System.identityHashCode(str2));
		
		if(name == null)
			System.out.println("힙메모리에 저장된 데이터가 없다");
		str4 = null;
		if(str4 == null)
			System.out.println("힙메모리에 저장된 데이터가 없다. "
					+ "	-> 원래 힙 메모리에 있는 '신민철' 문자열은 매칭된 레퍼런스변수가 없어짐");
	}
}
