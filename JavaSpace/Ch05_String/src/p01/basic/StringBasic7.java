package p01.basic;

// 문자열 크기 비교 : s1.compareTo(s2)
// 1. s1과 s2의 뮨자열을 알파벳 순서로 비교하는데 첫번째 문자부터 비교함
// 2. 실행결과
//	- s1 > s2 	>> 양수
//	- s1 < s2 	>> 음수
// 	- s1 == s2 	>> 0

public class StringBasic7 {
	public static void main(String[] args) {
		String s1 = "apple";
		String s2 = "banana";
		String s3 = "pineapple";
		String s4 = "banana";
		

		System.out.println(s1 + "과 " + s2 + "의 크기 비교 : " + s1.compareTo(s2));
		System.out.println(s1 + "과 " + s3 + "의 크기 비교 : " + s1.compareTo(s3));
		System.out.println(s2 + "과 " + s1 + "의 크기 비교 : " + s2.compareTo(s1));
		System.out.println(s2 + "과 " + s4 + "의 크기 비교 : " + s2.compareTo(s4));
		System.out.println("kiwi 와  orange의 크기비교 : " + "kiwi".compareTo("orange"));
	}
}
